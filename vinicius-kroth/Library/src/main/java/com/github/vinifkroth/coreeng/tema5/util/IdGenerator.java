package com.github.vinifkroth.coreeng.tema5.util;

public class IdGenerator {

	private Integer idNumber;


	public IdGenerator(Integer idNumber) {
		this.idNumber = idNumber;
	}

	public synchronized String generateID() {
		idNumber++;
		return idNumber.toString();
	}

	public String getCurrentId() {
		return idNumber.toString();
	}
}
