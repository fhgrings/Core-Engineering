import main.java.com.github.fhgrings._biblioteca.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BibliotecaTest {
    private GerenciadorLivros gerenciadorLivros = new GerenciadorLivros();
    private GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();

    @Test
    public void shouldAddBooks() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        gerenciadorLivros.cadatrarLivros(livro);
        assertEquals(livro, gerenciadorLivros.buscarLivroByAutor("Autor1"));
    }

    @Test
    public void shouldListAllBooks() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        assertEquals("Autor: Autor2 - Titulo: Titulo2 - ID: 9999\n" +
                "Autor: Autor1 - Titulo: Titulo1 - ID: 1111\n", gerenciadorLivros.listarLivros());
    }

    @Test
    public void shouldSearchAuthor() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        assertEquals(livro, gerenciadorLivros.buscarLivroByAutor("Autor1"));
    }

    @Test
    public void shouldSearchTittle() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        assertEquals(livro, gerenciadorLivros.buscarLivroByTitulo("Titulo1"));
    }

    @Test
    public void shouldRemoveBook() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        gerenciadorLivros.removerLivro("9999");
        assertEquals("Autor: Autor1 - Titulo: Titulo1 - ID: 1111\n", gerenciadorLivros.listarLivros());
    }

    @Test
    public void shouldRentBook() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);

        assertEquals(true,gerenciadorLivros.alugarLivro("Titulo1", "03160960080", "31/08/2018"));
    }

    @Test
    public void shouldReturnBook() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        gerenciadorLivros.alugarLivro("Titulo1", "03160960080", "01/08/2018");
        assertEquals(true,gerenciadorLivros.devolverLivro("1111",  "08/08/2018"));
    }

    @Test
    public void shouldRenewBook() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        gerenciadorLivros.alugarLivro("Titulo1", "03160960080", "01/08/2018");
        assertEquals(true, gerenciadorLivros.renovarLivro("1111","03160960080", "28/07/2018","04/08/2018"));
    }

    @Test
    public void shouldListRentBooks() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");
        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        gerenciadorLivros.alugarLivro("Titulo1", "Nome: a CPF: 2", "01/08/2018");
        assertEquals("Autor: Autor1 - Titulo: Titulo1 - ID: 1111 - Cliente Nome: a CPF: 2\n", gerenciadorLivros.listarLivrosAlugados());
    }

    @Test
    public void shouldListTop10Clients() {
        gerenciadorCliente.atualizarArray();
        assertEquals("Cliente: n    Livros Alugados: 55\n" +
                              "Cliente: i    Livros Alugados: 23\n" +
                              "Cliente: h    Livros Alugados: 13\n" +
                              "Cliente: j    Livros Alugados: 10\n" +
                              "Cliente: g    Livros Alugados: 9\n" +
                              "Cliente: f    Livros Alugados: 8\n" +
                              "Cliente: e    Livros Alugados: 7\n" +
                              "Cliente: d    Livros Alugados: 6\n" +
                              "Cliente: c    Livros Alugados: 5\n" +
                              "Cliente: m    Livros Alugados: 5\n", gerenciadorCliente.listarTopClientes());
    }

    @Test
    public void shouldListDelayedBooks() {
        Livro livro = new Livro("Titulo1", "Autor1", "1111");
        Livro livro2 = new Livro("Titulo3", "Autor2", "1000");
        Livro livro1 = new Livro("Titulo2", "Autor2", "9999");

        gerenciadorLivros.cadatrarLivros(livro1);
        gerenciadorLivros.cadatrarLivros(livro);
        gerenciadorLivros.cadatrarLivros(livro2);
        gerenciadorLivros.alugarLivro("Titulo2", "Nome: a CPF: 2", "030/08/2018");
        gerenciadorLivros.alugarLivro("Titulo1", "Nome: a CPF: 2", "028/08/2018");
        gerenciadorLivros.alugarLivro("Titulo3", "Nome: a CPF: 2", "20/09/2018");
        assertEquals("Autor: Autor2 - Titulo: Titulo2 - ID: 9999 - Cliente Nome: a CPF: 2 Dias de atraso: 6\n" +
                              "Autor: Autor1 - Titulo: Titulo1 - ID: 1111 - Cliente Nome: a CPF: 2 Dias de atraso: 8\n", gerenciadorLivros.listarAtrasados("05/09/2018"));
    }

}
