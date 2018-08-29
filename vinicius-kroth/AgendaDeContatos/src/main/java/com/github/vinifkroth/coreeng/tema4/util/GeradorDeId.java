package com.github.vinifkroth.coreeng.tema4.util;

public class GeradorDeId {

	private static Integer idNumber;

	public GeradorDeId() {
		idNumber = 0;
	}

	public synchronized String gerarId() {
		idNumber++;
		return idNumber.toString();
	}

	public String getIdAtual() {
		return idNumber.toString();
	}
}
