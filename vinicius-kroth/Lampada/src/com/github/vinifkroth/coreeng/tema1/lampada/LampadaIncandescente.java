package com.github.vinifkroth.coreeng.tema1.lampada;

public class LampadaIncandescente implements Lampada {

	private boolean estado;

	public LampadaIncandescente() {
		estado = false;
	}

	@Override
	public void on() {
		estado = true;

	}

	@Override
	public void off() {
		estado = false;

	}

}
