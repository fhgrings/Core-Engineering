package com.github.vinifkroth.coreeng.tema2.lampada;

public class LampadaFluorescente implements Lampada {
	private boolean estado;

	public LampadaFluorescente() {
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

	@Override
	public boolean getEstado() {
		return estado;
	}
}
