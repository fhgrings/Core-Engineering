package com.github.vinifkroth.coreeng.tema3.lampada;

public class Interruptor {

	private Lampada lampada;
	private boolean estado;

	public Interruptor(Lampada lampada) {
		this.lampada = lampada;
		estado = false;
	}
	
	public Interruptor(Lampada lampada, boolean estado) {
		this.lampada = lampada;
		this.estado = estado;
	}

	public String inverterEstado() {
		if (estado) {
			estado = false;
			return "Sua lâmpada foi apagada";
		} else {
			estado = true;
			return "Sua lâmpada foi ligada";
		}

	}

	public String getEstado() {
		if (estado)
			return "Sua lâmpada está ligada";
		else
			return "Sua lâmpada está desligada";

	}
}
