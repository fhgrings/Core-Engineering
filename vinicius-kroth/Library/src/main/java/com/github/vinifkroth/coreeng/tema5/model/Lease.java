package com.github.vinifkroth.coreeng.tema5.model;

import java.time.LocalDate;

public class Lease {
	private Book book;
	private Client client;
	private LocalDate borrowDate;

	public Lease(Book book, Client client, LocalDate borrowDate) {
		this.book = book;
		this.client = client;
		this.borrowDate = borrowDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	@Override
	public String toString() {
		return "book id=" + book.getId() + ", client document=" + client + ", borrowDate=" + borrowDate;
	}
	
	public String toStringInfoFormat() {
		return book.getId() + ";" +client.getDocument() + ";"+ borrowDate;
	}

}
