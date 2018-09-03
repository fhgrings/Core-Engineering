package com.github.rafaritter44.core_eng.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Cliente cliente1, cliente2;
    private Emprestimo emprestimo;

    @Before
    public void setup() {
        List<Livro> disponiveis =  new ArrayList<>();
        Livro revolta = new Livro(0, "A Revolta de Atlas", "Ayn Rand");
        Livro fountainhead = new Livro(1, "The Fountainhead", "Ayn Rand");
        Livro crime = new Livro(2, "Crime and Punishment", "Dostoiévski");
        disponiveis.add(fountainhead);
        Map<String, Cliente> clientes = new HashMap<>();
        Cliente rafael = new Cliente("Rafael Ritter");
        Cliente marcelo = cliente1 = new Cliente("Marcelo Serpa");
        Cliente tarzan = cliente2 =new Cliente("Tarzan");
        clientes.put("Rafael Ritter", rafael);
        clientes.put("Marcelo Serpa", marcelo);
        clientes.put("Tarzan", tarzan);
        List<Emprestimo> emprestimos = new ArrayList<>();
        emprestimos.add(new Emprestimo(revolta, rafael));
        revolta.emprestar();
        rafael.emprestar(revolta);
        emprestimos.add(emprestimo = new Emprestimo(crime, tarzan));
        crime.emprestar();
        tarzan.emprestar(crime);
        biblioteca = new Biblioteca(disponiveis, clientes, emprestimos, 3);
    }

    @Test
    public void cadastrar() {
        biblioteca.cadastrar("Beyond Good and Evil", "Friedrich Nietzsche");
        String livro = "Título: Beyond Good and Evil | Autor: Friedrich Nietzsche | Situação: Disponível | ID: 3";
        assertTrue(biblioteca.listar().contains(livro));
    }

    @Test
    public void listar() {
        String livros = "Livros encontrados:\n" +
                "Título: The Fountainhead | Autor: Ayn Rand | Situação: Disponível | ID: 1\n" +
                "Título: A Revolta de Atlas | Autor: Ayn Rand | Situação: Emprestado | ID: 0\n" +
                "Título: Crime and Punishment | Autor: Dostoiévski | Situação: Emprestado | ID: 2\n";
        assertEquals(livros, biblioteca.listar());
    }

    @Test
    public void excluir() {
        biblioteca.excluir(1);
        String livros = "Livros encontrados:\n" +
                "Título: A Revolta de Atlas | Autor: Ayn Rand | Situação: Emprestado | ID: 0\n" +
                "Título: Crime and Punishment | Autor: Dostoiévski | Situação: Emprestado | ID: 2\n";
        assertEquals(livros, biblioteca.listar());
    }

    @Test
    public void buscarPorTitulo() {
        String livros = "Livros encontrados:\n" +
                "Título: Crime and Punishment | Autor: Dostoiévski | Situação: Emprestado | ID: 2\n";
        assertEquals(livros, biblioteca.buscarPorTitulo("Crime and Punishment"));
    }

    @Test
    public void buscarPorAutor() {
        String livros = "Livros encontrados:\n" +
                "Título: The Fountainhead | Autor: Ayn Rand | Situação: Disponível | ID: 1\n" +
                "Título: A Revolta de Atlas | Autor: Ayn Rand | Situação: Emprestado | ID: 0\n";
        assertEquals(livros, biblioteca.buscarPorAutor("Ayn Rand"));
    }

    @Test
    public void emprestar() {
        biblioteca.emprestar(cliente1, 1);
        String emprestimoString = "Título: The Fountainhead | Autor: Ayn Rand | Situação: Emprestado | ID: 1\n" +
                "Emprestado para: Marcelo Serpa";
        assertTrue(biblioteca.relatorioEmprestados().contains(emprestimoString));
    }

    @Test
    public void getCliente() {
        assertEquals(cliente1, biblioteca.getCliente("Marcelo Serpa"));
    }

    @Test
    public void devolver() {
        try {
            biblioteca.devolver(cliente2, 2);
        } catch(Exception excecao) {
            fail();
        }
        String emprestados = "Livros encontrados:\n" +
                "Título: A Revolta de Atlas | Autor: Ayn Rand | Situação: Emprestado | ID: 0\n" +
                "Emprestado para: Rafael Ritter\n";
        assertEquals(emprestados, biblioteca.relatorioEmprestados());
    }

    @Test
    public void renovar() {
        assertTrue(biblioteca.renovar(emprestimo));
    }

    @Test
    public void getEmprestimo() {
        assertEquals(emprestimo, biblioteca.getEmprestimo(2, cliente2).get());
    }

    @Test
    public void relatorioEmprestados() {
        String emprestados = "Livros encontrados:\n" +
                "Título: A Revolta de Atlas | Autor: Ayn Rand | Situação: Emprestado | ID: 0\n" +
                "Emprestado para: Rafael Ritter\n" +
                "Título: Crime and Punishment | Autor: Dostoiévski | Situação: Emprestado | ID: 2\n" +
                "Emprestado para: Tarzan\n";
        assertEquals(emprestados, biblioteca.relatorioEmprestados());
    }

    @Test
    public void top10alugadores() {
        String alugadores = "Lista de clientes:\n" +
                "1. Tarzan: 1 empréstimos\n" +
                "2. Rafael Ritter: 1 empréstimos\n" +
                "3. Marcelo Serpa: 0 empréstimos\n";
        assertEquals(alugadores, biblioteca.relatorioTop10Alugadores());
    }

    @Test
    public void relatorioAtrasos() {
        String clientes = "Nenhum cliente encontrado.\n";
        assertEquals(clientes, biblioteca.relatorioAtrasos());
    }
}