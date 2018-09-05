package main.java.com.github.fhgrings._biblioteca;

public class Livro {
    private String id;
    private String autor;
    private String titulo;
    private String cpfAluguel;
    private String dataDevolucao;
    private boolean disponivel = true;

    public Livro(String titulo, String autor, String id) {
        this.autor = autor;
        this.id = id;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCpfAluguel() {
        return cpfAluguel;
    }

    public void setCpfAluguel(String cpfAluguel) {
        this.cpfAluguel = cpfAluguel;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Autor: " + autor + " - Titulo: " + titulo + " - ID: " + id;
    }
}