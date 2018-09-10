package com.github.henriqueidt.coreeng.temabiblioteca.testes;
import com.github.henriqueidt.coreeng.temabiblioteca.ManipulacaoClientes;
import org.junit.Assert;
import org.junit.Test;

public class ManipulacaoClientesTest {
    ManipulacaoClientes manipulacaoClientesTest = new ManipulacaoClientes();

    @Test
    public void topClientesTest() {
        manipulacaoClientesTest.cadastraCliente("NOME");
        manipulacaoClientesTest.cadastraCliente("TESTE");
        manipulacaoClientesTest.cadastraCliente("ALEATORIO");
        manipulacaoClientesTest.clientes.get(0).setHistorico(5);
        manipulacaoClientesTest.clientes.get(1).setHistorico(12);
        manipulacaoClientesTest.clientes.get(2).setHistorico(7);
        String top = manipulacaoClientesTest.topClientes();
        Assert.assertEquals("Nome: TESTE Livros retirados: 12\n" +
                "Nome: ALEATORIO Livros retirados: 7\n" +
                "Nome: NOME Livros retirados: 5", top);
    }
}
