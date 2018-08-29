package com.github.vinifkroth.coreeng.tema4.testes;

import org.junit.Test;

import com.github.vinifkroth.coreeng.tema4.model.Contato;
import com.github.vinifkroth.coreeng.tema4.service.AgendaDeContatos;
import com.github.vinifkroth.coreeng.tema4.util.GeradorDeId;

import static org.junit.Assert.*;

import org.junit.Before;

public class AgendaDeContatosTest {

	@Test
	public void testInserirContatoNaLista() {
		AgendaDeContatos agenda = new AgendaDeContatos();
		Contato contato = new Contato("Teste1", "997885542", "teste@teste.com.br");
		agenda.adicionar(contato);
		assertEquals(1, agenda.getTamanho());
	}

	@Test
	public void testRemoverContatoDaLista() {
		AgendaDeContatos agenda = new AgendaDeContatos();
		Contato contato = new Contato("Teste1", "997885542", "teste@teste.com.br");
		agenda.adicionar(contato);
		agenda.removerPorId("1");
		assertEquals(0, agenda.getTamanho());
	}

	@Test
	public void testBuscarContatoPorID() {
		AgendaDeContatos agenda = new AgendaDeContatos();
		Contato contato = new Contato("Teste1", "997885542", "teste@teste.com.br");
		agenda.adicionar(contato);
		assertEquals("nome=Teste1, numero=997885542, email=teste@teste.com.br, id=1", agenda.buscarPorId("1").toString());
	}

	@Test
	public void testBuscarContatoPorNome() {
		AgendaDeContatos agenda = new AgendaDeContatos();
		Contato contato = new Contato("Teste1", "997885542", "teste@teste.com.br");
		agenda.adicionar(contato);
		assertEquals("nome=Teste1, numero=997885542, email=teste@teste.com.br, id=1", agenda.buscarPorNome("Teste1").toString());
	}

	@Test
	public void testListarTodos() {
		AgendaDeContatos agenda = new AgendaDeContatos();
		Contato contato = new Contato("Teste1", "997885542", "teste@teste.com.br");
		Contato contato2 = new Contato("Teste2", "997885542", "teste2@teste.com.br");
		agenda.adicionar(contato);
		agenda.adicionar(contato2);
		assertEquals("Lista de contatos:\n" + "\n" + "nome=Teste1, numero=997885542, email=teste@teste.com.br, id=1\n"
				+ "nome=Teste2, numero=997885542, email=teste2@teste.com.br, id=2\n", agenda.listar());
	}

	@Test
	public void testGerencidorId() {
		GeradorDeId gerente = new GeradorDeId();
		gerente.gerarId();
		gerente.gerarId();
		gerente.gerarId();
		assertEquals("3", gerente.getIdAtual());
	}

}
