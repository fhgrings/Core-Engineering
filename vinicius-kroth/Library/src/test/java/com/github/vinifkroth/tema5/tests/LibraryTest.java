package com.github.vinifkroth.tema5.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.vinifkroth.coreeng.tema5.model.Book;
import com.github.vinifkroth.coreeng.tema5.model.Client;
import com.github.vinifkroth.coreeng.tema5.model.Lease;
import com.github.vinifkroth.coreeng.tema5.service.Library;

public class LibraryTest {
	private List<Book> books;
	private List<Client> clients;
	private List<Lease> leases;

	@Before
	public void setUp() {
		Client client = new Client("Teste", 0, "02731300051");
		books = new ArrayList<>();
		clients = new ArrayList<>();
		clients.add(client);
		leases = new ArrayList<>();
	}

	@Test
	public void testAddBook() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		assertEquals("title=Teste1, author=teste1, id=1, leased=false\n", library.findBookByTitle("Teste1"));
	}

	@Test
	public void testRemoveBook() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.removeBook("1");
		assertEquals("Livro não encontrado em nosso banco de dados", library.removeBook("1"));
	}

	@Test
	public void testListAllBooks() {
		Book book = new Book("Teste1", "teste1");
		Book book2 = new Book("Teste2", "teste2");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.addBook(book2);
		assertEquals("\nLista de livros cadastrados:\n" + "title=Teste1, author=teste1, id=1, leased=false\n"
				+ "title=Teste2, author=teste2, id=2, leased=false\n", library.listAllBooks());
	}

	@Test
	public void testListAvailableBooks() {
		Book book = new Book("Teste1", "teste1");
		Book book2 = new Book("Teste2", "teste2");
		Book book3 = new Book("Teste3", "teste3");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.addBook(book2);
		library.addBook(book3);
		library.lease("02731300051", "3");
		assertEquals("Lista de livros disponíveis:\n" + "title=Teste1, author=teste1, id=1, leased=false\n"
				+ "title=Teste2, author=teste2, id=2, leased=false\n", library.listAvailableBooks());
	}

	@Test
	public void testFindBookByTitle() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		assertEquals("title=Teste1, author=teste1, id=1, leased=false\n", library.findBookByTitle("Teste1"));
	}

	@Test
	public void testFindBookByAuthor() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		assertEquals("title=Teste1, author=teste1, id=1, leased=false\n", library.findBooksByAuthor(("teste1")));
	}

	@Test
	public void testLeaseBook() {
		LocalDate todayDate = LocalDate.now();
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.lease("02731300051", "1");
		assertEquals("\nLista de livros locados: \nTeste1 de id: 1 foi alugado pelo cliente: Teste na data: " + todayDate + "\n",
				library.getLeasedList());
	}
	
	@Test
	public void testRenewBook() {
		LocalDate todayDate = LocalDate.now();
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.lease("02731300051", "1");
		library.renewLease("1");
		assertEquals("\nLista de livros locados: \nTeste1 de id: 1 foi alugado pelo cliente: Teste na data: " + todayDate + "\n",
				library.getLeasedList());
	}
	
	@Test
	public void testReturnBook() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.lease("02731300051", "1");
		library.returnBook("1");
		assertEquals("\nNo momento não existe nenhuma locação ativa\n",
				library.getLeasedList());
	}

	@Test
	public void testDelayedList() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.lease("02731300051", "1");
		assertEquals("Nenhum livro atrasado", library.getDelayedList());
	}

	@Test
	public void testGetTop10Leasers() {
		Book book = new Book("Teste1", "teste1");
		Library library = new Library(books, 0, clients, leases);
		library.addBook(book);
		library.lease("02731300051", "1");
		assertEquals("\nTOP 10 CLIENTES QUE MAIS ALUGAM\n" + "name=Teste, numberOfLeases=1, document=02731300051\n",
				library.getTop10Leasers());
	}

}
