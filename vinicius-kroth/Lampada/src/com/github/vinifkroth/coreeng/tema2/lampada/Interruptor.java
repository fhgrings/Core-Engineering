package com.github.vinifkroth.coreeng.tema2.lampada;

public class Interruptor {

	private Lampada lampada;

	public Interruptor(Lampada lampada) {
		this.lampada = lampada;
	}

	public String inverterEstado() {
		if (lampada.getEstado()) {
			lampada.off();
			return "Sua lâmpada foi apagada";
		} else {
			return "Sua lâmpada foi ligada";
		}

	}

	public String getEstado() {
		if (lampada.getEstado())
			return "Sua lâmpada está ligada";
		else
			return "Sua lâmpada está desligada";

	}
}
