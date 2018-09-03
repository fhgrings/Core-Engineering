package com.github.rafaritter44.core_eng.biblioteca.model;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        emprestado = false;
    }

    public Livro(int id, String titulo, String autor, boolean emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
    }

    public void emprestar() { emprestado = true; }
    public void devolver() { emprestado = false; }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    private String situacao() {
        return emprestado?"Emprestado":"Disponível";
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Autor: " + autor + " | Situação: " + situacao() + " | ID: " + id;
    }

}
