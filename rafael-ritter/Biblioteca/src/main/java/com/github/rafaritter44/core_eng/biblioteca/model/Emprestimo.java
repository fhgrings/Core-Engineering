package com.github.rafaritter44.core_eng.biblioteca.model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Emprestimo {

    private Livro livro;
    private Cliente cliente;
    private LocalDate data;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        data = LocalDate.now();
    }

    public Emprestimo(Livro livro, Cliente cliente, LocalDate data) {
        this.livro = livro;
        this.cliente = cliente;
        this.data = data;
    }

    public boolean representa(int id, String nomeCliente) {
        return id == livro.getId() && nomeCliente.equals(cliente.getNome());
    }

    public boolean renovar() {
        if(DAYS.between(data, LocalDate.now()) > 7)
            return false;
        data = LocalDate.now();
        return true;
    }

    public Livro getLivro() { return livro; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getData() { return data; }

    public int diasAtraso() {
        int diasEmprestimo = (int) DAYS.between(data, LocalDate.now());
        if(diasEmprestimo <= 7)
            return 0;
        return diasEmprestimo - 7;
    }

    public String toString() {
        return livro + "\nEmprestado para: " + cliente.getNome();
    }

    public String getClienteAtraso() {
        return cliente.getNome() + " está " + diasAtraso() + " dia(s) atrasado(a) na devolução de \"" +
                livro.getTitulo() + "\", por " + livro.getAutor();
    }

}
