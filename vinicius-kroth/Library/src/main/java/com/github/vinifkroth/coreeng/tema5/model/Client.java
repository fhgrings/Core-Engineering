package com.github.vinifkroth.coreeng.tema5.model;

public class Client {

	private String name;
	private Integer numberOfLeases;
	private String document;

	public Client(String name, Integer numberOfLeases, String document) {
		this.name = name;
		this.numberOfLeases = numberOfLeases;
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfLeases() {
		return numberOfLeases;
	}

	public void setNumberOfLeases(Integer numberOfLeases) {
		this.numberOfLeases = numberOfLeases;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "name=" + name + ", numberOfLeases=" + numberOfLeases + ", document=" + document;
	}

	public String toStringInfoFormat() {

		return name + ";" + numberOfLeases + ";" + document;
	}

}
