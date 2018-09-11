package com.github.mariaeduardacunha.tema4.agenda.model;

public class Contato {

    private String nome;
    private int id;
    private String celular;
    private String email;

    public Contato(String nome, int id, String s, String celular) {
        this.setNome(nome);
        this.setId(id);
        this.setCelular(celular);
        this.setEmail(email);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato {" + "\n\tnome: " + nome + "\n\tid: " + id + "\n\tcelular: " + celular + "\n\temail:" + email + "\n}";
    }
}

