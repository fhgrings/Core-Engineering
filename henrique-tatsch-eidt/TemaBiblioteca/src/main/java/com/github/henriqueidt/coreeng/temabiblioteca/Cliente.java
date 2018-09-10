package com.github.henriqueidt.coreeng.temabiblioteca;

public class Cliente {
    public String nome;
    public int historico;

    public Cliente() {
    }

    public Cliente(String nome, int historico) {
        this.setNome(nome);
        this.setHistorico(historico);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setHistorico(int historico) {
        this.historico = historico;
    }

    public int getHistorico() {
        return historico;
    }

    @Override
    public String toString () {
        return nome + ";" + historico;
    }
}

