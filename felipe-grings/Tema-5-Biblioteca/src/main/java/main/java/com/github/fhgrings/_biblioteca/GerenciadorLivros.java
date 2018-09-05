package main.java.com.github.fhgrings._biblioteca;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GerenciadorLivros {
    private String path = "Livros.txt";

    private List<Livro> livrosList = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void atualizarArray(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                Livro livro = new Livro(parts[0],parts[1], parts[2]);
                livrosList.add(livro);
            }
        } catch (IOException e) {
            System.out.println("Erro");
        }
    }

    public void cadastrarLivros(Livro livro) {
        livrosList.add(livro);
        cadastrarNoBanco(livro);
        System.out.println("livro cadastrado!");
    }

    public String listarLivros() {
        StringBuffer sbf = new StringBuffer();
        for (Livro livro : livrosList) {
             sbf.append(livro);
             sbf.append(livro.isDisponivel() ? "\n" : " --------- Alugado\n");
         }
         return sbf.toString();
    }

    public Livro buscarLivroByAutor(String autor) {
        for (Livro livro : livrosList){
            if(livro.getAutor().contains(autor))
                 return livro;
        }
        return null;
    }

    public Livro buscarLivroByTitulo(String titulo) {
        for (Livro livro : livrosList){
            if(livro.getTitulo().contains(titulo))
                return livro;
        }
        return null;
    }
    public Livro buscarLivroById(String id) {
        for (Livro livro : livrosList){
            if(livro.getId().contains(id))
                return livro;
        }
        return null;
    }

    public boolean removerLivro(String id) {
        Livro livro = buscarLivroById(id);
        if(livro == null){
            System.out.println("Livro nao encontrado");
            return false;
        }
        if(livro.isDisponivel()) {
	    livrosList.remove(livro);
	    System.out.println("Livro " + id + " removido");
	    return true;
        }

        System.out.println("Livro alugado");
        return false;
    }

    public boolean alugarLivro(String titulo, String cpf, String devolucaoDia) {
        Livro livro = buscarLivroByTitulo(titulo);
        if(livro == null) {
            System.out.println("Livro nao encontrado");
            return false;
        }
        if(livro.isDisponivel()){
            livro.setCpfAluguel(cpf);
            livro.setDisponivel(false);
            livro.setDataDevolucao(devolucaoDia);
            System.out.println("Livro Alugado com sucesso!");
            return true;
            }
        System.out.println("Livro nao disponivel");
        return false;
        }

    public boolean renovarLivro (String id, String cpf, String data, String novaDevolucaoDia) {
        Livro livro = buscarLivroById(id);
        if(livro == null) {
            System.out.println("livro nao encontrado");
            return false;
        }
        if (livro.getCpfAluguel() == cpf && verificarAtraso(data, livro.getDataDevolucao()) < 8) {
            livro.setDataDevolucao(novaDevolucaoDia);
            System.out.println("Livro Renovado com sucesso");
            return true;
        }
        System.out.println("Livro Não Renovado");
        return false;
    }

    public boolean devolverLivro(String id, String data){
        Livro livro = buscarLivroById(id);
        if(livro == null) {
            System.out.println("Livro nao encontrado");
            return false;
        }
        if (verificarAtraso(data, livro.getDataDevolucao()) < 8) {
            livro.setCpfAluguel("null");
            livro.setDisponivel(true);
            System.out.println( "Livro Ok!");
            return true;
        }
        long multa = (verificarAtraso(data, livro.getDataDevolucao()) - 7) * 5;
        livro.setCpfAluguel("null");
        livro.setDisponivel(true);
        System.out.println("Multa de R$" + multa);
        return true;
        }

    public String listarLivrosAlugados() {
        StringBuffer sbf = new StringBuffer();
        for (Livro livro : livrosList) {
            if (!livro.isDisponivel()) {
                sbf.append(livro + " - Cliente ");
                sbf.append(livro.getCpfAluguel() + "\n");
            }
        }
        return sbf.toString();
    }

    public String listarAtrasados(String dataHoje) {
        StringBuffer sbf = new StringBuffer();
        for (Livro livro : livrosList) {
            if (!livro.isDisponivel() && verificarAtraso(dataHoje, livro.getDataDevolucao()) > 0 ){
                sbf.append(livro + " - Cliente ");
                sbf.append(livro.getCpfAluguel());
                sbf.append(" Dias de atraso: " + verificarAtraso(dataHoje, livro.getDataDevolucao()) + "\n");
            }
        }
        return sbf.toString();
    }

    public long verificarAtraso(String data, String dataDevolucao) {
        try {
            Date dataDev = sdf.parse(dataDevolucao);
            Date dataHoje = sdf.parse(data);
            if(dataHoje.before(dataDev))
                return 0;
            else {
                long diff = dataHoje.getTime() - dataDev.getTime();
                return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void cadastrarNoBanco(Livro livro){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) {
            bw.write(livro.getTitulo() + " - " + livro.getAutor() + " - " + livro.getId());
            bw.newLine();
            System.out.println(livro.getTitulo() + " - " + livro.getAutor() + " - " + livro.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
