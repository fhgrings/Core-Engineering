package com.github.walterolivos.core_eng.tema_5.Services;

import com.github.walterolivos.core_eng.tema_5.models.Livro;
import com.github.walterolivos.core_eng.tema_5.models.Usuario;

import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo){
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro(){
        return livro;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate now){
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString(){
        return ("Id livro: " + livro.getId() + " - Usuario: " + usuario + " - Data emprestimo: " + dataEmprestimo);
    }

    public String toStringEmprestimoInfo(){
        return (livro.getId() + ";" + usuario.getDocumento() + ";" + dataEmprestimo);
    }

}
