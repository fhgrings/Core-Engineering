package com.github.rafaritter44.core_eng.biblioteca.util;

import com.github.rafaritter44.core_eng.biblioteca.model.Biblioteca;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Conversor {

    private static final Gson gson = new Gson();

    public static void gravar(String arquivo, Biblioteca biblioteca) {
        String conteudo = gson.toJson(biblioteca);
        Path caminho = Paths.get(arquivo);
        try (PrintWriter gravador = new PrintWriter(Files.newBufferedWriter(caminho, Charset.forName("utf8")))) {
            gravador.print(conteudo);
        } catch (IOException excecao) {
            excecao.printStackTrace();
        }
    }
    public static Biblioteca ler(String arquivo) {
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(arquivo));
        } catch (IOException excecao) {
            return null;
        }
        return gson.fromJson(new String(bytes, Charset.forName("utf8")), Biblioteca.class);
    }

    public static Optional<Integer> toInteiro(String entrada) throws NumberFormatException {
        try {
            return Optional.ofNullable(Integer.parseInt(entrada));
        } catch(NumberFormatException excecao) {
            return Optional.empty();
        }
    }

}
