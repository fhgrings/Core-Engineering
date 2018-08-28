package com.github.vinifkroth.coreeng.tema5.model;

public class Book {

	private String title, author, id;
	private boolean leased;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		leased = false;
	}

	public Book(String title, String author, String id, boolean leased) {
		this.title = title;
		this.author = author;
		this.id = id;
		this.leased = leased;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isLeased() {
		return leased;
	}

	public void setLeased(boolean leased) {
		this.leased = leased;
	}

	@Override
	public String toString() {
		return "title=" + title + ", author=" + author + ", id=" + id + ", leased=" + leased;
	}

	public String toStringInfoFormat() {
		return title + ";" + author + ";" + id + ";" + leased;
	}

}
