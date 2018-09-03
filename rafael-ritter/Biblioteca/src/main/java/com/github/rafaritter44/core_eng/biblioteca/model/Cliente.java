package com.github.rafaritter44.core_eng.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cliente {

    private String nome;
    private List<Livro> emprestados;
    private int emprestimos;

    public Cliente(String nome) {
        this.nome = nome;
        emprestados = new ArrayList<>();
        emprestimos = 0;
    }

    public Cliente(String nome, List<Livro> emprestados, int emprestimos) {
        this.nome = nome;
        this.emprestados = emprestados;
        this.emprestimos = emprestimos;
    }

    public void emprestar(Livro livro) {
        emprestados.add(livro);
        emprestimos++;
    }

    public Optional<Livro> devolver(int id) {
        if(id < 0)
            return Optional.empty();
        for(int i=0; i<emprestados.size(); i++) {
            if (id == emprestados.get(i).getId())
                return Optional.ofNullable(emprestados.remove(i));
        }
        return Optional.empty();
    }

    public String listarLivros() {
        StringBuilder livros = new StringBuilder();
        for(Livro livro: emprestados)
            livros.append(livro + "\n");
        return "Livros emprestados para " + nome + ":\n" + livros.toString();
    }

    public boolean semLivros() { return emprestados.size() == 0; }

    public boolean podeEmprestar() { return emprestados.size() != 5; }

    public String getNome() { return nome; }
    public int getEmprestimos() { return emprestimos; }

    public String getNomeEmprestimos() { return nome + ": " + emprestimos + " empréstimos"; }

}
