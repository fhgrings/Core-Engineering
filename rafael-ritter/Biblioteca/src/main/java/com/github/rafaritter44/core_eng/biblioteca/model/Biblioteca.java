package com.github.rafaritter44.core_eng.biblioteca.model;

import com.github.rafaritter44.core_eng.biblioteca.exceptions.LivroNaoEncontradoException;
import com.github.rafaritter44.core_eng.biblioteca.util.Conversor;

import java.rmi.NoSuchObjectException;
import java.util.*;

import static java.util.Comparator.comparing;

public class Biblioteca {

    private List<Livro> disponiveis;
    private Map<String, Cliente> clientes;
    private List<Emprestimo> emprestimos;
    private int contadorID;
    private static final String NENHUM_LIVRO = "Nenhum livro encontrado.\n";
    private static final String LIVROS_ENCONTRADOS = "Livros encontrados:\n";
    private static final String NENHUM_CLIENTE = "Nenhum cliente encontrado.\n";
    private static final String LISTA_CLIENTES = "Lista de clientes:\n";

    public Biblioteca() {
        disponiveis = new ArrayList<>();
        clientes = new HashMap<>();
        emprestimos = new ArrayList<>();
        contadorID = 0;
    }

    public Biblioteca(List<Livro> disponiveis, Map<String, Cliente> clientes,
                      List<Emprestimo> emprestimos, int contadorID) {
        this.disponiveis = disponiveis;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
        this.contadorID = contadorID;
    }

    public void cadastrar(String titulo, String autor) {
        disponiveis.add(new Livro(contadorID, titulo, autor));
        contadorID++;
    }

    public String listar() {
        StringBuilder livros = new StringBuilder();
        for(Livro livro: disponiveis)
            livros.append(livro + "\n");
        for(Emprestimo emprestimo: emprestimos)
            livros.append(emprestimo.getLivro() + "\n");
        return livros.length() == 0 ? NENHUM_LIVRO: LIVROS_ENCONTRADOS + livros.toString();
    }

    public SituacaoLivro excluir(int id) {
        if(id < 0)
            return SituacaoLivro.INEXISTENTE;
        for(int i=0; i<disponiveis.size(); i++) {
            if (id == disponiveis.get(i).getId()) {
                disponiveis.remove(i);
                return SituacaoLivro.REGULAR;
            }
        }
        for(Emprestimo emprestimo: emprestimos) {
            if (id == emprestimo.getLivro().getId())
                return SituacaoLivro.EMPRESTADO;
        }
        return SituacaoLivro.INEXISTENTE;
    }

    public String buscarPorTitulo(String titulo) {
        StringBuilder livros = new StringBuilder();
        for(Livro livro: disponiveis) {
            if (livro.getTitulo().equalsIgnoreCase(titulo))
                livros.append(livro + "\n");
        }
        for(Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo))
                livros.append(emprestimo.getLivro() + "\n");
        }
        return livros.length() == 0 ? NENHUM_LIVRO: LIVROS_ENCONTRADOS + livros.toString();
    }

    public String buscarPorAutor(String autor) {
        StringBuilder livros = new StringBuilder();
        for(Livro livro: disponiveis) {
            if (livro.getAutor().equalsIgnoreCase(autor))
                livros.append(livro + "\n");
        }
        for(Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getLivro().getAutor().equalsIgnoreCase(autor))
                livros.append(emprestimo.getLivro() + "\n");
        }
        return livros.length() == 0 ? NENHUM_LIVRO: LIVROS_ENCONTRADOS + livros.toString();
    }

    public SituacaoLivro emprestar(Cliente cliente, int id) {
        if(id < 0)
            return SituacaoLivro.INEXISTENTE;
        for(int i=0; i<disponiveis.size(); i++) {
            if (id == disponiveis.get(i).getId()) {
                Livro livro = disponiveis.remove(i);
                livro.emprestar();
                cliente.emprestar(livro);
                emprestimos.add(new Emprestimo(livro, cliente));
                return SituacaoLivro.REGULAR;
            }
        }
        for(Emprestimo emprestimo: emprestimos) {
            if (id == emprestimo.getLivro().getId())
                return SituacaoLivro.EMPRESTADO;
        }
        return SituacaoLivro.INEXISTENTE;
    }

    public Cliente getCliente(String nome) { return clientes.get(nome); }

    public int devolver(Cliente cliente, int id) throws LivroNaoEncontradoException {
        Optional<Livro> livroOpcional = cliente.devolver(id);
        if(!livroOpcional.isPresent())
            throw new LivroNaoEncontradoException(cliente.getNome() + " não está com esse livro.\n");
        Livro livro = livroOpcional.get();
        livro.devolver();
        disponiveis.add(livro);
        for(int i=0; i<emprestimos.size(); i++) {
            if (livro.getId() == (emprestimos.get(i).getLivro().getId())) {
                Emprestimo emprestimo = emprestimos.remove(i);
                return emprestimo.diasAtraso() * 5;
            }
        }
        throw new LivroNaoEncontradoException(cliente.getNome() + " não está com esse livro.\n");
    }

    public boolean renovar(Emprestimo emprestimo) { return emprestimo.renovar(); }

    public Optional<Emprestimo> getEmprestimo(int id, Cliente cliente) {
        if(id < 0)
            return Optional.empty();
        String nomeCliente = cliente.getNome();
        for(Emprestimo emprestimo: emprestimos) {
            if (emprestimo.representa(id, nomeCliente))
                return Optional.ofNullable(emprestimo);
        }
        return Optional.empty();
    }

    public String relatorioEmprestados() {
        StringBuilder emprestados = new StringBuilder();
        for(Emprestimo emprestimo: emprestimos)
            emprestados.append(emprestimo + "\n");
        return emprestados.length() == 0 ? NENHUM_LIVRO: LIVROS_ENCONTRADOS + emprestados.toString();
    }

    private List<Cliente> top10Alugadores() {
        List<Cliente> listaClientes = new ArrayList<>(clientes.values());
        listaClientes.sort(comparing(Cliente::getEmprestimos).reversed());
        int tamanho = 10;
        if(listaClientes.size() < tamanho)
            tamanho = listaClientes.size();
        return listaClientes.subList(0, tamanho);
    }

    public String relatorioTop10Alugadores() {
        List<Cliente> listaClientes = top10Alugadores();
        StringBuilder top10 = new StringBuilder();
        for(int i=0; i<listaClientes.size(); i++) {
            top10.append((i+1) + ". " + listaClientes.get(i).getNomeEmprestimos() + "\n");
        }
        return top10.length() == 0 ? NENHUM_CLIENTE: LISTA_CLIENTES + top10.toString();
    }

    public String relatorioAtrasos() {
        StringBuilder atrasos = new StringBuilder();
        for(Emprestimo emprestimo: emprestimos) {
            int diasAtraso = emprestimo.diasAtraso();
            if(diasAtraso > 0)
                atrasos.append(emprestimo.getClienteAtraso() + "\n");
        }
        return atrasos.length() == 0 ? NENHUM_CLIENTE: LISTA_CLIENTES + atrasos.toString();
    }

}
