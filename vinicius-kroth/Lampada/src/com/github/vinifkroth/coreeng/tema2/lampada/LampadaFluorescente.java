package com.github.vinifkroth.coreeng.tema2.lampada;

import java.util.concurrent.ThreadLocalRandom;

public class LampadaFluorescente implements Lampada {
	private final int frequencia = ThreadLocalRandom.current().nextInt(50, 500);
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

	public String frequenciaDaLampada() {
		return "Sua lâmpada tem frequencia de: " + frequencia;
	}

	@Override
	public String toString() {
		return "LampadaFluorescente [frequencia=" + frequencia + "]";
	}

}
