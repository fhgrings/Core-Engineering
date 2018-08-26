package com.github.vinifkroth.coreeng.tema3.lampada;

public class LampadaFluorescente implements Lampada {

	@Override
	public void on() {
		System.out.println("Sua lâmpada está ligada");
	}

	@Override
	public void off() {
		System.out.println("Sua lâmpada está desligada");
	}
}
