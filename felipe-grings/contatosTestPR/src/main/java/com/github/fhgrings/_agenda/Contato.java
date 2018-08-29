package main.java.com.github.fhgrings._agenda;

public class Contato {

    private String nome;
    private int id;

    public Contato(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public void setContato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return nome + " ID: " + id;
    }

}
