package com.github.henriqueidt.coreeng.temaagenda;

public class Contato {
    private String nome;
    private String numero;
    private int id;

    public Contato() {

    }

    public Contato(String nome, String numero, int id) {
        this.setNome(nome);
        this.setNumero(numero);
        this.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Numero: " + numero + " Id: " + id;
    }
}