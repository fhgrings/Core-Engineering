package com.github.henriqueidt.coreeng.temabiblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static com.github.henriqueidt.coreeng.temabiblioteca.ManipulacaoClientes.clientes;

public class LivroDao {
    private static int id = 1;
    private List<Livro> livros = new ArrayList();

    public void inserirLivro(String titulo, String autor) {
        for (Livro livro : livros) {
            id = livro.getId();
        }
        id++;
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setId(id);
        livro.setLocador("livre");
        livros.add(livro);
    }

    public void removerLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                if (!livros.get(livros.indexOf(livro)).isRetirado()) {
                    livros.remove(livros.indexOf(livro));
                    break;
                } else {
                    System.out.println("Livro não pode ser excluido pois esta retirado");
                }
            }
        }
    }

    public String consultaLivro(String titulo) {
        String livroConsultado = "";
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                livroConsultado = "Livro: " + livros.get(livros.indexOf(livro)).getTitulo() + " Autor: " + livros.get(livros.indexOf(livro)).getAutor() + " Id: " + livros.get(livros.indexOf(livro)).getId();
            break;
            } else {
                livroConsultado = "Livro nao encontrado";
            }
        }
        return livroConsultado;
    }

    public String listarLivros() {
        String stringLivros = null;
        for (Livro livro : livros) {
            if (stringLivros == null) {
                stringLivros = "Livro: " + livro.getTitulo() + " Autor: " + livro.getAutor() + " Id: " + livro.getId();
            } else {
                stringLivros += "\n";
                stringLivros += "Livro: " + livro.getTitulo() + " Autor: " + livro.getAutor() + " Id: " + livro.getId();
            }
        }
        return stringLivros;
    }

    public boolean retirarLivro(String titulo, String nome) {
        boolean retirado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo) && !livro.isRetirado()) {
                livros.get(livros.indexOf(livro)).setRetirado(true);
                livros.get(livros.indexOf(livro)).setLocador(nome);
                livros.get(livros.indexOf(livro)).setDataRetirada((LocalDate.now()));
                retirado = true;
                break;
            }
        }
            return retirado;
    }

    public int devolucaoLivro(String titulo) {
        int atraso = 0;
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                livros.get(livros.indexOf(livro)).setRetirado(false);
                livros.get(livros.indexOf(livro)).setLocador("livre");
                long difDias = ChronoUnit.DAYS.between(livros.get(livros.indexOf(livro)).getDataRetirada(), LocalDate.now());
                if (difDias <= 7) {
                    atraso = 0;
                } else {
                    atraso = (int) (difDias - 7);
                }
                break;
            }
        }
        return atraso;
    }

    public String livrosEmprestados() {
        String stringLivros = null;
        for (Livro livro : livros) {
            if (stringLivros == null && livro.isRetirado()) {
                stringLivros = "Livro: " + livro.getTitulo();
                stringLivros += " Retirado por: " + livro.getLocador();
            } else if (livro.isRetirado()){
                stringLivros += "\nLivro: ";
                stringLivros += livro.getTitulo();
                stringLivros += " Retirado por: " + livro.getLocador();
            }
        }
        return stringLivros;
    }

    public void renovarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                livros.get(livros.indexOf(livro)).setDataRetirada(LocalDate.now());
                break;
            }
        }
    }

    public String livrosAtrasados() {
        String stringLivros = null;
        int index = 0;
        for (Livro livro : livros) {
            if (livros.get(index).getDataRetirada() != null){
                long difDias = ChronoUnit.DAYS.between(livro.getDataRetirada(), LocalDate.now());
            if (!(livro.getLocador().isEmpty()) && (stringLivros == null) && (difDias > 7)) {
                 stringLivros = "Nome: " + livro.getLocador() + " está atrasado " + (difDias - 7) + " dias com o livro " + livro.getTitulo();
            } else if (!(livro.getLocador().isEmpty()) && difDias > 7) {
                stringLivros += "\nNome: " + livro.getLocador() + " esta atrasado " + (difDias - 7) + " dias com o livro " + livro.getTitulo();
            }
            }
        }
        return stringLivros;
    }

    public List getLivros() {
        return livros;
    }

    public void separaConteudo (String conteudo) {
        String[] objetosSeparados = (conteudo.split(";"));
        int i = 0;
        do {
            Livro livro = new Livro();
            livro.setTitulo(objetosSeparados[i]); i++;
            livro.setAutor(objetosSeparados[i]); i++;
            livro.setId(Integer.parseInt(objetosSeparados[i])); i++;
            livro.setLocador(objetosSeparados[i]); i++;
            livro.setRetirado(Boolean.parseBoolean(objetosSeparados[i])); i++;
            if (!objetosSeparados[i].equals("null")) {
                DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
                LocalDate date = LocalDate.parse("20150927", formatter);
                formatter = DateTimeFormatter.ISO_DATE;
                date = LocalDate.parse(objetosSeparados[i], formatter);
                livro.setDataRetirada(date);
            } i++;
            livros.add(livro);
        } while (!objetosSeparados[i].equals("*"));
        i++;
        while (!objetosSeparados[i].equals("@")) {
            Cliente cliente = new Cliente();
            cliente.setNome(objetosSeparados[i]); i++;
            cliente.setHistorico(Integer.parseInt(objetosSeparados[i])); i++;
            clientes.add(cliente);
        }
    }

    public int confereLivrosRetirados(String nome) {
        int livrosRetirados = 0;
        for (Livro livro : livros) {

            if (livro.getLocador() != null && livro.getLocador().equals(nome)) {
                livrosRetirados++;
            }
        }
        return livrosRetirados;
    }

    public boolean confereAtrasos(String nome) {
        int index = -1;
        boolean atrasado = false;
        for (Livro livro : livros) {
            index = livros.indexOf(livro);
            long difDias = ChronoUnit.DAYS.between(livros.get(index).getDataRetirada(), LocalDate.now());
            if (!livro.getLocador().isEmpty() && livro.getLocador().equals(nome) && difDias > 7) {
                atrasado = true;
            }
        }
        return atrasado;
    }
}
