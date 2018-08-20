package com.github.vinifkroth.coreeng.tema2.lampada;

public class Main {

	public static void main(String args[]) {

		LampadaFluorescente lampadaFluorescente = new LampadaFluorescente();
		LampadaIncandescente lampadaIncandescente = new LampadaIncandescente();

		Interruptor gerenteFluorescente = new Interruptor(lampadaFluorescente);
		Interruptor gerenteIncandescente = new Interruptor(lampadaIncandescente);

		System.out.println("########### OPERAÇÕES LAMPADA FLUORESCENTE ###########");
		System.out.println(gerenteFluorescente.getEstado());
		System.out.println(gerenteFluorescente.inverterEstado());
		System.out.println(gerenteFluorescente.inverterEstado());
		
		
		
		System.out.println("\n########### OPERAÇÕES LAMPADA INCADESCENTE ###########");
		System.out.println(gerenteIncandescente.getEstado());
		System.out.println(gerenteIncandescente.inverterEstado());
		System.out.println(gerenteIncandescente.inverterEstado());
		
		

	}
}
