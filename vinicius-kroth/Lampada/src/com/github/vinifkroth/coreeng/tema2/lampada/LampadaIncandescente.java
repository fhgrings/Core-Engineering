package com.github.vinifkroth.coreeng.tema2.lampada;

import java.util.concurrent.ThreadLocalRandom;

public class LampadaIncandescente implements Lampada {

	private boolean estado;
	private final int tempoDeAquecimento = ThreadLocalRandom.current().nextInt(20, 200);

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

	public String tempoDeAquecimento() {
		return "O tempo de aquecimento é de: " + tempoDeAquecimento;
	}

	@Override
	public String toString() {
		return "LampadaIncandescente [tempoDeAquecimento=" + tempoDeAquecimento + "]";
	}

	@Override
	public boolean getEstado() {
		return estado;
	}

}
