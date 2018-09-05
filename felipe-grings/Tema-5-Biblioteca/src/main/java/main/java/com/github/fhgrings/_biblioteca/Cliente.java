package main.java.com.github.fhgrings._biblioteca;


public class Cliente {
    private String nome;
    private String cpf;
    private int livrosAlugados;
    private int historicoLivrosAlugados;


    public Cliente(String nome, String cpf, int historicoLivrosAlugados) {
        this.nome = nome;
        this.cpf = cpf;
        this.historicoLivrosAlugados = historicoLivrosAlugados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(int livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }

    public int getHistAluguel() {
        return historicoLivrosAlugados;
    }

    public void setHistAluguel(int histAluguel) {
        this.historicoLivrosAlugados = histAluguel;
    }

    @Override
    public String toString() {
        return nome + " - cpf:" + cpf;
    }
}
