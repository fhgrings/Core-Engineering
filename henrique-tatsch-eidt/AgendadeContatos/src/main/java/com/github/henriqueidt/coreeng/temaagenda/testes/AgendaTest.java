package com.github.henriqueidt.coreeng.temaagenda.testes;
import com.github.henriqueidt.coreeng.temaagenda.Agenda;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AgendaTest {
    Agenda relacoes = new Agenda();

    @Test
    public void testeInserirContato() {
       relacoes.inserirContato("nome de teste", "436324");
        Assert.assertEquals("nome de teste", relacoes.contatos.get(0).getNome());
    }

    @Test
    public void testeRemoverContato() {
        relacoes.inserirContato("nomeexcluido", "23456");
        relacoes.inserirContato("nome testavel", "12345");
        relacoes.removerContato("nomeexcluido");
        Assert.assertNotEquals("nomeexcluido", relacoes.contatos.get(0).getNome());

    }

    @Test
    public void testeConsultaContatoNome() {
        relacoes.inserirContato("nome de consulta", "23456");
       String contato = relacoes.consultaContatoNome("nome de consulta");
       Assert.assertEquals("Nome: nome de consulta Numero: 23456 Id: 1000", contato);
    }

    @Test
    public void testeConsultaContatoId() {
        relacoes.inserirContato("nome para testar", "12345");
        String contato = relacoes.consultaContatoId(1000);
        Assert.assertEquals("Nome: nome para testar Numero: 12345 Id: 1000", contato);
    }

    @Test
    public void testelistarContatos() {
        relacoes.inserirContato("nome testelista", "12345");
        relacoes.inserirContato("nome2", "23456");
        Assert.assertEquals("Nome: nome testelista Numero: 12345 Id: 1000\n" +
                "Nome: nome2 Numero: 23456 Id: 1001\n", relacoes.listarContatos());
    }
}
