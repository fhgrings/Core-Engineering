package com.github.henriqueidt.coreeng.temabiblioteca;

import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String autor;
    private int id;
    private boolean retirado;
    private String locador = "";
    private LocalDate dataRetirada;

    public Livro(){
    }

    public Livro(String titulo, String autor, int id, boolean retirado, String locador, LocalDate dataRetirada) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setId(id);
        this.setRetirado(retirado);
        this.setLocador(locador);
        this.setDataRetirada(dataRetirada);
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRetirado() {
        return this.retirado;
    }

    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }

    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    @Override
    public String toString() {
        return titulo + ";" + autor + ";" + id + ";" + retirado + ";" + locador + ";" + dataRetirada;
    }

}
