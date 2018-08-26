package com.github.vinifkroth.coreeng.tema3.testes;

import org.junit.Test;

import com.github.vinifkroth.coreeng.tema3.lampada.*;

import static org.junit.Assert.*;

public class InterruptorTest {

	@Test
	public void testSwitchMethodOnLampadaFluorescente() {
		Lampada lampada = new LampadaFluorescente();
		Interruptor interruptor = new Interruptor(lampada);
		interruptor.inverterEstado();
		assertEquals("Sua lâmpada está ligada", interruptor.getEstado());

	}

	@Test
	public void testSwitchMethodOffLampadaFluorescente() {
		Lampada lampada = new LampadaFluorescente();
		Interruptor interruptor = new Interruptor(lampada, true);
		interruptor.inverterEstado();
		assertEquals("Sua lâmpada está desligada", interruptor.getEstado());

	}

	@Test
	public void testSwitchMethodOnLampadaIncandescente() {
		Lampada lampada = new LampadaIncandescente();
		Interruptor interruptor = new Interruptor(lampada);
		interruptor.inverterEstado();
		assertEquals("Sua lâmpada está ligada", interruptor.getEstado());

	}

	@Test
	public void testSwitchMethodOffLampadaIncandescente() {
		Lampada lampada = new LampadaIncandescente();
		Interruptor interruptor = new Interruptor(lampada, true);
		interruptor.inverterEstado();
		assertEquals("Sua lâmpada está desligada", interruptor.getEstado());

	}
}
