package com.github.henriqueidt.coreeng.temabiblioteca;
import java.io.*;
import java.io.BufferedReader;
import java.util.List;

import static com.github.henriqueidt.coreeng.temabiblioteca.ManipulacaoClientes.clientes;

public class ManipulacaoArquivos {

    public void write(List<Livro> livros) {
        try (PrintWriter gravaArq = new PrintWriter( new FileWriter("livros.txt"))) {
            for (Livro livro : livros) {
                gravaArq.println(livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getId() + ";" + livro.getLocador() + ";" + livro.isRetirado() + ";" + livro.getDataRetirada());
            }
            gravaArq.println("*");
            for (Cliente c : clientes) {
                gravaArq.println(c.getNome() + ";" + c.getHistorico());
            }
            gravaArq.println("@");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo!");
        }
    }

    public String read() {
        String conteudo = "";
        try (BufferedReader lerArq = new BufferedReader(new FileReader("livros.txt"))) {
            String linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + ";";
                    linha = lerArq.readLine();
                }
            } catch (IOException ex) {
                System.out.println("Erro ao ler arquivo!");
            }
        return conteudo;
    }
}


