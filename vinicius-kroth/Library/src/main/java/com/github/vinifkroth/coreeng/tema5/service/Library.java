package com.github.vinifkroth.coreeng.tema5.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.github.vinifkroth.coreeng.tema5.model.Book;
import com.github.vinifkroth.coreeng.tema5.model.Client;
import com.github.vinifkroth.coreeng.tema5.model.Lease;
import com.github.vinifkroth.coreeng.tema5.util.IdGenerator;

public class Library {

	private List<Book> books;
	private IdGenerator idGenerator;
	private List<Client> clients;
	private List<Lease> leases;

	public Library(List<Book> books, Integer currentIdNumber, List<Client> clients, List<Lease> leases) {
		this.books = books;
		idGenerator = new IdGenerator(currentIdNumber);
		this.clients = clients;
		this.leases = leases;
	}

	public String addBook(Book book) {
		book.setId(idGenerator.generateID());
		if (books.add(book))
			return "Livro cadastrado com sucesso";
		else
			return "Ocorreu um erro inesperado. Por favor tente novamente";

	}

	public String listAllBooks() {
		StringBuilder str = new StringBuilder();
		str.append("\nLista de livros cadastrados:\n");
		for (Book book : books) {
			str.append(book.toString())
			   .append("\n");
		}

		return str.toString();
	}

	public String listAvailableBooks() {
		StringBuilder str = new StringBuilder();
		str.append("Lista de livros disponíveis:\n");
		for (Book book : books) {
			if (!book.isLeased()) {
				str.append(book.toString())
				   .append("\n");
			}
		}
		if(str.toString().equals("Lista de livros disponíveis:\n"))
			return "Nenhum livro disponível";
		return str.toString();
	}

	public String removeBook(String id) {
		Optional<Book> retrievedBook = books.stream()
				.filter(b -> b.getId()
				.equals(id))
				.findFirst();
		if (!retrievedBook.isPresent()) {
			return "Livro não encontrado em nosso banco de dados";
		}
		if (retrievedBook.get().isLeased())
			return "Não foi possível excluir este livro, o mesmo está alugado";

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getId().equals(retrievedBook.get().getId())) {
				books.remove(i);
				break;
			}
		}

		return "Livro excluído com sucesso";
	}

	public String findBookByTitle(String title) {
		StringBuilder str = new StringBuilder();
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				str.append(book.toString())
				   .append("\n");
			}
		}
		if (str.toString().isEmpty())
			return "Não foram encontrados nenhum livro com este nome";
		return str.toString();
	}

	public String findBooksByAuthor(String author) {
		StringBuilder str = new StringBuilder();
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author)) {
				str.append(book.toString())
				   .append("\n");
			}
		}
		if (str.toString().isEmpty())
			return "Não foram encontrados nenhum livro deste autor";
		return str.toString();
	}

	public String lease(String document, String bookId) {
		Optional<Book> retrievedBook = books.stream()
				.filter(b -> b.getId()
				.equals(bookId))
				.findFirst();
		if (!retrievedBook.isPresent())
			return "Livro não encontrado";

		if (retrievedBook.get().isLeased())
			return "Livro já alugado";

		Optional<Client> retrievedClient = clients
				.stream().filter(c -> c.getDocument()
				.equals(document))
				.findFirst();
		if (!retrievedClient.isPresent())
			return "Cliente não encontrado";

		if (clientCurrentLeases(retrievedClient.get().getDocument()) == 5)
			return "Cliente já possui 5 aluguéis, favor devolva um livro para alugar outro";

		Lease lease = new Lease(retrievedBook.get(), retrievedClient.get(), LocalDate.now());
		leases.add(lease);
		alterBookState(bookId);
		increseClientLeases(document);
		return "Livro alugado com sucesso";

	}

	public String getTop10Leasers() {
		Collections.sort(clients, (c1, c2) -> c1
				.getNumberOfLeases()
				.compareTo(c2.getNumberOfLeases()));
		
		StringBuilder str = new StringBuilder();
		str.append("\nTOP 10 CLIENTES QUE MAIS ALUGAM\n");
		for (int i = clients.size()-1; i > clients.size() - 10 && i >= 0; i--) {
			str.append(clients.get(i))
			   .append("\n");
		}
		return str.toString();
	}

	public String getDelayedList() {
		StringBuilder str = new StringBuilder();
		str.append("\nLista de livros atrasados: \n");
		for (Lease lease : leases) {
			if (!checkLeaseValidity(lease.getBorrowDate().toEpochDay())) {
				str.append(lease.getBook().getTitle())
				   .append(" de id: ")
				   .append( lease.getBook().getId())
				   .append(" alugado pelo cliente: ")
				   .append(lease.getClient().getName())
                   .append("\n");
			}	
		}
		if(str.toString().equals("\nLista de livros atrasados: \n"))
			return "Nenhum livro atrasado";		
		
		return str.toString();
	}

	public String getLeasedList() {
		StringBuilder str = new StringBuilder();
		str.append("\nLista de livros locados: \n");
		for (Lease lease : leases) {
			str.append(lease.getBook().getTitle())
			   .append(" de id: ")
			   .append( lease.getBook().getId())
			   .append(" foi alugado pelo cliente: ")
			   .append(lease.getClient().getName())
			   .append(" na data: ")
			   .append(lease.getBorrowDate())
			   .append("\n");
			
		}
		if(str.toString().equals("\nLista de livros locados: \n"))
			return "\nNo momento não existe nenhuma locação ativa\n";
		return str.toString();
	}

	public String renewLease(String bookId) {
		try {
			Lease lease = findLeaseByBookId(bookId);
			if (!checkLeaseValidity(lease.getBorrowDate().toEpochDay()))
				return "O livro está atrasado, impossível de renovar.";
			lease.setBorrowDate(LocalDate.now());
			return "Livro renovado com sucesso.";

		} catch (Exception e) {
			return "Id fornecida não está presente em nosso banco de dados\n";
		}
	}

	public String returnBook(String bookId) {
		
		try {
			Lease lease = findLeaseByBookId(bookId);
			alterBookState(bookId);
			leases.remove(lease);
			if (checkLeaseValidity(lease.getBorrowDate().toEpochDay())) {
				return "Livro atrasado devolvido, uma taxa de :" + calculateDelayFee(lease.getBorrowDate().toEpochDay())
						+ " reais, será cobrada";
			}
			return "Livro devolvido com sucesso";
		} catch (Exception e) {
			return "Id fornecida não está presente em nosso banco de dados\n";
		}

	}
	private void increseClientLeases(String document) {
		for (Client client : clients) {
			if (client.getDocument().equals(document))
				client.setNumberOfLeases(client.getNumberOfLeases() + 1);
		}
	}

	private int clientCurrentLeases(String document) {
		int leaseCount = 0;
		for (Lease lease : leases) {
			if (lease.getClient().getDocument().equals(document))
				leaseCount++;
		}
		return leaseCount;
	}

	private void alterBookState(String bookId) {
		for (Book book : books) {
			if (book.getId().equals(bookId)) {
				book.setLeased(!book.isLeased());
			}

		}
	}

	private int calculateDelayFee(long borrowDate) {
		long today = LocalDate.now().toEpochDay();
		return (int) ((today - 7.0) - borrowDate * 5);
	}
	
	private Lease findLeaseByBookId(String id) throws Exception{
		Optional<Lease> retrievedLease = leases.stream()
				.filter(l -> l.getBook().getId()
				.equals(id))
				.findFirst();
		
		if(retrievedLease.isPresent())
			return retrievedLease.get();
		
		throw new Exception("LEASE_NOT_FOUND_EXCP");
	}
	
	private boolean checkLeaseValidity(long borrowDate) {
		long today = LocalDate.now().toEpochDay();
		if (today - 8 >= borrowDate)
			return false;
		else
			return true;
	}
	

	public String getLibraryInfo() {
		StringBuilder str = new StringBuilder();
		str.append(idGenerator.getCurrentId() + "\n");

		for (Book book : books) {
			str.append("$")
			   .append(book.toStringInfoFormat())
			   .append("\n");
		}

		for (Client client : clients) {
			str.append("&")
			   .append(client.toStringInfoFormat())
			   .append("\n");
		}

		for (Lease lease : leases) {
			str.append("#")
			   .append(lease.toStringInfoFormat())
			   .append("\n");
		}

		return str.toString();
	}

}