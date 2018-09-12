package com.github.walterolivos.core_eng.tema_5.Services;

import com.github.walterolivos.core_eng.tema_5.models.Livraria;
import com.github.walterolivos.core_eng.tema_5.models.Livro;
import com.github.walterolivos.core_eng.tema_5.models.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciaTexto {

    private static List<Livro> livros;
    private static List<Usuario> usuarios;
    private static List<Emprestimo> emprestimos;

    public static Livraria extractData(){

        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        emprestimos = new ArrayList<>();
        Integer numeroId = 0;
        String linha;
        try(BufferedReader ler = new BufferedReader(new FileReader("arquivo.txt"))){

                numeroId = Integer.parseInt(ler.readLine());
                while (ler.ready()){
                    linha = ler.readLine();
                    if (linha.charAt(0) == '$'){
                        parseLivros(linha);
                    } else if (linha.charAt(0) == '&'){
                        parseClients(linha);
                    } else {
                        parseEmprestimo(linha);
                    }
                }
        }   catch (Exception e){
            e.printStackTrace();
        }
        return new Livraria(livros, numeroId, usuarios, emprestimos);
    }

    public static void salvaInfo(String info){
        try (BufferedWriter ler = new BufferedWriter(new FileWriter("arquivo.txt"))){
            ler.write(info);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void parseEmprestimo(String emprestimoInfo){
        String infoEmprestimo;
        infoEmprestimo = emprestimoInfo.substring(1);
        String []splitTexto = infoEmprestimo.split(";");
        String bookId = splitTexto[0];
        String documentoUsuario = splitTexto[1];

        Optional<Livro> livroDevolvido = livros.stream()
                .filter(b -> b.getId().equals(bookId)).findFirst();
        Optional<Usuario> usuarioDevolvido = usuarios.stream()
                .filter(c -> c.getDocumento().equals(documentoUsuario)).findFirst();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Emprestimo emprestimo = new Emprestimo(livroDevolvido.get(),usuarioDevolvido.get(),
                LocalDate.parse(splitTexto[2], formatter));
        emprestimos.add(emprestimo);
    }

    private static void parseLivros(String livroInfo){
        String infoLivro;
        infoLivro = livroInfo.substring(1);
        String[] splitTexto = infoLivro.split(";");
        Livro livro = new Livro(splitTexto[0], splitTexto[1], splitTexto[2], Boolean.parseBoolean(splitTexto[3]));
        livros.add(livro);
    }

    private static void parseClients(String usuarioInfo){
        String infoUser;
        infoUser = usuarioInfo.substring(1);
        String[] splitTxt = infoUser.split(";");
        Usuario usuario = new Usuario(splitTxt[0], Integer.parseInt(splitTxt[1]), splitTxt[2]);
        usuarios.add(usuario);
    }
}
