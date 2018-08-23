package com.github.vinifkroth.coreeng.tema1.lampada;

public class Main {

	public static void main(String args[]) {

		LampadaFluorescente lampadaFluorescente = new LampadaFluorescente();
		LampadaIncandescente lampadaIncandescente = new LampadaIncandescente();

		Interruptor interruptorFluorescente = new Interruptor(lampadaFluorescente);
		Interruptor interruptorIncandescente = new Interruptor(lampadaIncandescente);

		System.out.println("########### OPERAÇÕES LAMPADA FLUORESCENTE ###########");
		System.out.println(interruptorFluorescente.getEstado());
		System.out.println(interruptorFluorescente.inverterEstado());
		System.out.println(interruptorFluorescente.inverterEstado());
		
		
		
		System.out.println("\n########### OPERAÇÕES LAMPADA INCADESCENTE ###########");
		System.out.println(interruptorIncandescente.getEstado());
		System.out.println(interruptorIncandescente.inverterEstado());
		System.out.println(interruptorIncandescente.inverterEstado());
		
		

	}
}
