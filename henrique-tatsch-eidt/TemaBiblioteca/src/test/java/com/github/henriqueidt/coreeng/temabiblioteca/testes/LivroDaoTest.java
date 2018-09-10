package com.github.henriqueidt.coreeng.temabiblioteca.testes;
import com.github.henriqueidt.coreeng.temabiblioteca.LivroDao;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroDaoTest {
    LivroDao livrosTest = new LivroDao();

    @Test
    public void inserirLivroTest() {
        livrosTest.inserirLivro("TITULO", "AUTOR");
        Assert.assertEquals("TITULO", livrosTest.livros.get(0).getTitulo());
    }

    @Test
    public void removerLivroTest() {
        livrosTest.inserirLivro("EXCLUIDO", "DELETED");
        livrosTest.inserirLivro("TITULO", "AUTOR");
        livrosTest.removerLivro("EXCLUIDO");
        Assert.assertNotEquals("EXCLUIDO", livrosTest.livros.get(0).getTitulo());
    }

    @Test
    public void consultaLivroTest() {
        livrosTest.inserirLivro("TITULO", "AUTOR");
        String livro = livrosTest.consultaLivro("TITULO");
        Assert.assertEquals("Livro: TITULO Autor: AUTOR Id: 1000", livro);
    }

    @Test
    public void listarLivrosTest() {
        LivroDao.cleanArray();
        livrosTest.inserirLivro("EXCLUIDO", "DELETED");
        livrosTest.inserirLivro("TITULO", "AUTOR");
        String listaLivros = livrosTest.listarLivros();
        Assert.assertEquals("Livro: EXCLUIDO Autor: DELETED Id: 1000\n" +
                "Livro: TITULO Autor: AUTOR Id: 1001", listaLivros);
    }

    @Test
    public void retirarLivroTest() {
        livrosTest.inserirLivro("TITULO", "AUTOR");
        livrosTest.retirarLivro("TITULO", "NOME");
        Assert.assertTrue(livrosTest.livros.get(0).isRetirado());
    }

    @Test
    public void devolucaoLivroTest() {
        livrosTest.inserirLivro("TITULO", "AUTOR");
        livrosTest.retirarLivro("TITULO", "NOME");
        livrosTest.devolucaoLivro("TITULO");
        Assert.assertFalse(livrosTest.livros.get(0).isRetirado());
    }

    @Test
    public void livrosEmprestadosTest() {
        livrosTest.inserirLivro("TITULO", "AUTOR");
        livrosTest.inserirLivro("TESTE", "ESCRITOR");
        livrosTest.retirarLivro("TITULO", "NOME");
        livrosTest.retirarLivro("TESTE", "ESCRITOR");
        String listaLivros = livrosTest.livrosEmprestados();
        Assert.assertEquals("Livro: TITULO Retirado por: NOME\n" +
                "Livro: TESTE Retirado por: ESCRITOR", listaLivros);
    }

    @Test
    public void renovarLivroTest() {
        livrosTest.inserirLivro("TITULO", "AUTOR");
        String data = "2018-08-28";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate dataLocal = LocalDate.parse("20150927", formatter);
        formatter = DateTimeFormatter.ISO_DATE;
        dataLocal = LocalDate.parse(data, formatter);
        livrosTest.livros.get(0).setDataRetirada(dataLocal);
        livrosTest.renovarLivro("TITULO");
        data = String.valueOf(livrosTest.livros.get(0).getDataRetirada());
        Assert.assertEquals("2018-08-31" ,data);

    }

    @Test
    public void livrosAtrasadosTest() {
        LivroDao.cleanArray();
        livrosTest.inserirLivro("TITULO", "AUTOR");
        String data = "2018-08-22";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate dataLocal = LocalDate.parse("20150927", formatter);
        formatter = DateTimeFormatter.ISO_DATE;
        dataLocal = LocalDate.parse(data, formatter);
        livrosTest.livros.get(0).setDataRetirada(dataLocal);
        livrosTest.livros.get(0).setLocador("Cliente x");
        String listaLivros = livrosTest.livrosAtrasados();
        Assert.assertEquals("Nome: Cliente x está atrasado 2 dias com o livro TITULO", listaLivros);
    }


}
