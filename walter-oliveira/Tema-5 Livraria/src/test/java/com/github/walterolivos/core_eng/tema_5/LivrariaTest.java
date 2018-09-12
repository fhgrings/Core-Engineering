package com.github.walterolivos.core_eng.tema_5;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.github.walterolivos.core_eng.tema_5.models.Livraria;
import com.sun.security.ntlm.Client;
import org.junit.Before;
import org.junit.Test;

import com.github.walterolivos.core_eng.tema_5.models.Usuario;
import com.github.walterolivos.core_eng.tema_5.models.Livro;
import com.github.walterolivos.core_eng.tema_5.Services.Emprestimo;

public class LivrariaTest {

    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    @Before
    public void setUp(){
        Usuario usuario = new Usuario("Teste", 0, "01520033044");
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        usuarios.add(usuario);
        emprestimos = new ArrayList<>();
    }

    @Test
    public void testAdicionarLivro(){
        Livro livro = new Livro("TituloTest", "AutorTest");
        Livraria livraria = new Livraria(livros,0,usuarios,emprestimos);
        livraria.adicionarLivro(livro);
        livraria.removerLivro("1");
        assertEquals("Livro não encontrado",livraria.removerLivro("1"));
    }

    @Test
    public void testListarTodosLivros(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livro livro2 = new Livro("TituloTest2","AutorTest2");
        Livraria livraria = new Livraria(livros,0,usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.adicionarLivro(livro2);
        assertEquals("\nLista de livros:\n" + "Livro: TituloTest1" + " - Autor: AutorTest1" + " - Id: 1" + " - Emprestado: false\n"
                     + "Livro: TituloTest2" + " - Autor: AutorTest2" + " - Id: 2" + " - Emprestado: false\n", livraria.listarTodosLivros());
    }

    @Test
    public void testListarLivrosDisponiveis(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livro livro2 = new Livro("TituloTest2","AutorTest2");
        Livro livro3 = new Livro("TituloTest2","AutorTest2");
        Livraria livraria = new Livraria(livros,0,usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.adicionarLivro(livro2);
        livraria.adicionarLivro(livro3);
        livraria.emprestimo("01520033044", "3");
        assertEquals("Lista de livros disponiveis:\n" + "Livro: TituloTest1" + " - Autor: AutorTest1" + " - Id: 1" + " - Emprestado: false\n"
                + "Livro: TituloTest2" + " - Autor: AutorTest2" + " - Id: 2" + " - Emprestado: false\n", livraria.listarLivrosDisponiveis());
    }

    @Test
    public void testPesquisarLivroPeloTitulo(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        assertEquals("Livro: TituloTest1" + " - Autor: AutorTest1" + " - Id: 1" + " - Emprestado: false\n", livraria.pesquisarLivroPeloTitulo("TituloTest1"));
    }

    @Test
    public void testPesquisarLivroPeloAutor(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        assertEquals("Livro: TituloTest1" + " - Autor: AutorTest1" + " - Id: 1" + " - Emprestado: false\n", livraria.pesquisarLivrosPeloAutor("AutorTest1"));
    }

    @Test
    public void testEmprestimoLivro(){
        LocalDate data = LocalDate.now();
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.emprestimo("01520033044","1");
        assertEquals("\nLista de livros alugados: \nTituloTest1 de id: 1 foi alugado pelo cliente: Teste na data: " + data + "\n",
                livraria.getListaEmprestimos());
    }

    @Test
    public void testRenovarEmprestimo(){
        LocalDate data = LocalDate.now();
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.emprestimo("01520033044","1");
        livraria.renovarEmprestimo("1");
        assertEquals("\nLista de livros alugados: \nTituloTest1 de id: 1 foi alugado pelo cliente: Teste na data: " + data + "\n",
                livraria.getListaEmprestimos());
    }

    @Test
    public void testRetornarLivro(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.emprestimo("01520033044","1");
        livraria.retornarLivro("1");
        assertEquals("\nNo momento, não exitem livros alugados\n",livraria.getListaEmprestimos());
    }

    @Test
    public void testListaAtrasado(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.emprestimo("01520033044","1");
        assertEquals("Nenhum livro atrasado", livraria.getListaAtrasados());
    }

    @Test
    public void testGetTop10Emprestimos(){
        Livro livro1 = new Livro("TituloTest1","AutorTest1");
        Livraria livraria = new Livraria(livros, 0, usuarios,emprestimos);
        livraria.adicionarLivro(livro1);
        livraria.emprestimo("01520033044","1");
        assertEquals("\nTop 10 clientes que mais alugam\n" + "Nome: Teste - Numero emprestimos: 1 - Documento: 01520033044\n",
                livraria.getTop10Emprestimo());
    }
}
