package com.github.walterolivos.core_eng.tema_5.models;

import com.github.walterolivos.core_eng.tema_5.Services.Emprestimo;
import com.github.walterolivos.core_eng.tema_5.Services.GeradorId;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Livraria {

    private  List<Livro> livros;
    private GeradorId geradorId;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Livraria(List<Livro> livros, Integer numeroIdAtual, List<Usuario> usuarios, List<Emprestimo> emprestimos){
        this.livros = livros;
        geradorId = new GeradorId(numeroIdAtual);
        this.usuarios = usuarios;
        this.emprestimos = emprestimos;
    }

    public String adicionarLivro(Livro livro){
        livro.setId(geradorId.gerarId());
        if(livros.add(livro)){
            return "Livro cadastrado";
        } else {
            return "Ocorreu um erro";
        }
    }

    public String listarTodosLivros(){
        StringBuilder lista = new StringBuilder();
        lista.append("\nLista de livros:\n");
        for(Livro livro : livros){
            lista.append(livro.toString()).append("\n");
        }
        return lista.toString();
    }

    public String listarLivrosDisponiveis(){
        StringBuilder lista = new StringBuilder();
        lista.append("Lista de livros disponiveis:\n");
        for (Livro livro: livros){
            if(!livro.getEmprestado()){
                lista.append(livro.toString()).append("\n");
            }
        }
        if (lista.toString().equals("Lista de livro disponiveis:\n")){
            return "Nenhum livro disponivel";
        }
        return lista.toString();
    }

    public String removerLivro(String id){
        Optional<Livro> livroRetornado = livros.stream().filter(b -> b.getId().equals(id)).findFirst();
        if(!livroRetornado.isPresent()){
            return "Livro não encontrado";
        }
        if (livroRetornado.get().getEmprestado()){
            return "Não foi possivel excluir esse livro pois ele está alugado";
        }
        for (int i = 0; i < livros.size(); i++){
            if (livros.get(i).getId().equals(livroRetornado.get().getId())){
                livros.remove(i);
                break;
            }
        }
        return "Livro excluido";
    }

    public String pesquisarLivroPeloTitulo(String titulo){
        StringBuilder pesquisa = new StringBuilder();
        for (Livro livro : livros){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                pesquisa.append(livro.toString()).append("\n");
            }
        }
        if (pesquisa.toString().isEmpty()){
            return "Não foram encontrados nenhum livro com esse nome";
        }
        return pesquisa.toString();
    }

    public String pesquisarLivrosPeloAutor(String autor){
        StringBuilder pesquisa = new StringBuilder();
        for (Livro livro : livros){
            if(livro.getAutor().equalsIgnoreCase(autor)){
                pesquisa.append(livro.toString()).append("\n");
            }
        }
        if (pesquisa.toString().isEmpty()){
            return "Não foram encontrados nenhum livro com esse autor";
        }
        return pesquisa.toString();
    }

    public String emprestimo(String documento, String idLivro){
        Optional<Livro> livroRetornado = livros.stream().filter(b -> b.getId().equals(idLivro)).findFirst();
        if(!livroRetornado.isPresent()){
            return "Livro não encontrado";
        }
        if(livroRetornado.get().getEmprestado()){
            return "Livro ja alugado";
        }
        Optional<Usuario> usuarioRetornado = usuarios.stream().
                filter(b -> b.getDocumento().equals(documento)).findFirst();
        if (!livroRetornado.isPresent()){
            return "Cliente não encontrado";
        }
        if (usuarioEmprestimosAtuais(usuarioRetornado.get().getDocumento()) == 5){
            return "Cliente já possui 5 alugueis";
        }

        Emprestimo emprestimo = new Emprestimo(livroRetornado.get(), usuarioRetornado.get(),LocalDate.now());
        emprestimos.add(emprestimo);
        alterarEstadoLivro(idLivro);
        incrementarEmprestimoUsuarios(documento);
        return "Livro alugado com sucesso";
    }

    public String getTop10Emprestimo(){
        Collections.sort(usuarios, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2)   {
                return Integer.valueOf(u2.getNumeroEmprestimos()).compareTo(u1.getNumeroEmprestimos());
            }
        });

        StringBuilder lista = new StringBuilder();
        lista.append("\nTop 10 clientes que mais alugam\n");
        for(int i = usuarios.size()-1; i > usuarios.size() - 10 && i >=0; i++){
            lista.append(usuarios.get(i)).append("\n");
        }
        return lista.toString();
    }

    public String getListaAtrasados(){
        StringBuilder lista = new StringBuilder();
        lista.append("\nLista de livros atrasados:\n");
        for (Emprestimo emprestimo: emprestimos){
            if(!checarValidadeEmprestimo(emprestimo.getDataEmprestimo().toEpochDay())){
                lista.append(emprestimo.getLivro().getTitulo())
                        .append(" de id: ")
                        .append(emprestimo.getLivro().getId())
                        .append(" alugado pelo cliente: ")
                        .append(emprestimo.getUsuario().getNome())
                        .append("\n");
            }
        }
        if(lista.toString().equals("\nLista de livros atrasados:\n")){
            return "Nenhum livro atrasado";
        }
        return lista.toString();
    }

    public String getListaEmprestimos(){
        StringBuilder lista = new StringBuilder();
        lista.append("\nLista de livros alugados: \n");
        for (Emprestimo emprestimo : emprestimos){
            lista.append(emprestimo.getLivro().getTitulo())
                    .append(" de id: ")
                    .append(emprestimo.getLivro().getId())
                    .append(" foi alugado pelo cliente: ")
                    .append(emprestimo.getUsuario().getNome())
                    .append(" na data: ")
                    .append(emprestimo.getDataEmprestimo())
                    .append("\n");
        }
        if (lista.toString().equals("\nLista de livros alugados: \n")){
            return "\nNo momento, não exitem livros alugados\n";
        }
        return lista.toString();
    }

    public String renovarEmprestimo(String idLivro){
        try{
            Emprestimo emprestimo = encontrarEmprestadoPeloId(idLivro);
            if (!checarValidadeEmprestimo(emprestimo.getDataEmprestimo().toEpochDay())){
                return "O livro esta atrasado, não e possivel renovar";
            }
            emprestimo.setDataEmprestimo(LocalDate.now());
            return "Livro renovado com sucesso";
        } catch (Exception e){
            return "Id fornecida não existe";
        }
    }

    public String retornarLivro(String idLivro){
        try {
            Emprestimo emprestimo = encontrarEmprestadoPeloId(idLivro);
            alterarEstadoLivro(idLivro);
            emprestimos.remove(emprestimo);
            if (checarValidadeEmprestimo(emprestimo.getDataEmprestimo().toEpochDay())){
                return "Livro atrasado devolvido, uma taxa de: " + calcularMultaAtraso
                        (emprestimo.getDataEmprestimo().toEpochDay()) + " reais será cobrada";
            }
            return "Livro devolvido";

        } catch (Exception e){
            return "Id fornecida não existe";
        }
    }

    private void incrementarEmprestimoUsuarios(String documento){
        for (Usuario usuario: usuarios){
            if (usuario.getDocumento().equals(documento)){
                usuario.setNumeroEmprestimos(usuario.getNumeroEmprestimos() + 1);
            }
        }
    }

    private int usuarioEmprestimosAtuais(String documento){
        int contaEmprestimo = 0;
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.getUsuario().getDocumento().equals(documento)){
                contaEmprestimo++;
            }
        }
        return contaEmprestimo;
    }

    private void alterarEstadoLivro(String idLivro){
        for (Livro livro : livros){
            if (livro.getId().equals(idLivro)){
                livro.setEmprestado(!livro.getEmprestado());
            }
        }
    }

    private int calcularMultaAtraso(long dataEmprestimo){
        long hoje = LocalDate.now().toEpochDay();
        return (int) ((hoje - 7.0 ) - dataEmprestimo * 5);
    }

    private Emprestimo encontrarEmprestadoPeloId(String id) throws Exception{
        Optional<Emprestimo> emprestimoRetornado = emprestimos.stream()
                .filter(l -> l.getLivro().getId().equals(id)).findFirst();
        if(emprestimoRetornado.isPresent()){
            return emprestimoRetornado.get();
        }
        throw new Exception("Emprestimo não encontrado");
    }

    private boolean checarValidadeEmprestimo(long dataEmprestimo){
        long hoje = LocalDate.now().toEpochDay();
        if (hoje - 8 >= dataEmprestimo){
            return false;
        } else {
            return true;
        }
    }

    public String getInfoLivraria(){
        StringBuilder info = new StringBuilder();
        info.append(geradorId.gerarId() + "\n");

        for (Livro livro : livros){
            info.append("$").append(livro.toStringLivroInfo()).append("\n");
        }
        for (Usuario usuario : usuarios){
            info.append("&").append(usuario.toStringUsuarioInfo()).append("\n");
        }
        for (Emprestimo emprestimo : emprestimos){
            info.append("#").append(emprestimo.toStringEmprestimoInfo()).append("\n");
        }
        return info.toString();
    }
}
