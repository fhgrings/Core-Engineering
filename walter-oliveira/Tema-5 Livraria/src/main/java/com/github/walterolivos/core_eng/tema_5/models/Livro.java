package com.github.walterolivos.core_eng.tema_5.models;

public class Livro {

    private String id;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        emprestado = false;
    }

    public Livro(String titulo, String autor, String id, boolean emprestado){
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.emprestado = emprestado;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public boolean getEmprestado(){
        return emprestado;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    @Override
    public String toString(){
        return ("Livro: " + titulo + " - Autor: " + autor + " - Id: " + id + " - Emprestado: " + emprestado);
    }

    public String toStringLivroInfo(){
        return (titulo + ";" + autor + ";" + id + ";"+ emprestado);
    }


}
