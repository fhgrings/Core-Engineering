package com.github.walterolivos.core_eng.tema_5.Services;
import com.github.walterolivos.core_eng.tema_5.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {

    private String lista;
    List<Livro> listaLivros = new ArrayList<>();

    public void cadastroLivro(Livro livro) {
        listaLivros.add(livro);
    }


    public String searchByTitulo(String titulo){
        for (Livro livro : listaLivros){
            if(livro.getTitulo().contains(titulo)){
                return livro.getAutor();
            }
        }
        return "Não encontrado";
    }

    public String searchByAutor(String autor){
        for (Livro livro : listaLivros){
            if (livro.getAutor() == autor){
                return livro.getTitulo();
            }
        }
        return "Não encontrado";
    }
}
