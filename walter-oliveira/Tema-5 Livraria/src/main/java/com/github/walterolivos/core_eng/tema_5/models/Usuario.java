package com.github.walterolivos.core_eng.tema_5.models;

public class Usuario{

    private String nome;
    private int numeroEmprestimos;
    private String documento;

    public Usuario(String nome, int numeroEmprestimos, String documento){
        this.nome = nome;
        this.numeroEmprestimos = numeroEmprestimos;
        this.documento = documento;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroEmprestimos(){
        return numeroEmprestimos;
    }

    public void setNumeroEmprestimos(int numeroEmprestimos){
        this.numeroEmprestimos = numeroEmprestimos;
    }

    public String getDocumento(){
        return documento;
    }

    public void setDocumento(String documento){
        this.documento = documento;
    }

    @Override
    public String toString(){
        return ("Nome: " + nome + " - Numero emprestimos: " + numeroEmprestimos + " - Documento: ");
    }

    public String toStringUsuarioInfo(){
        return (nome + ";" + numeroEmprestimos + ";" + documento);
    }

}
