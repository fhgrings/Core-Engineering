package test.java;

import main.java.com.github.fhgrings._agenda.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AgendaTest {

    private GerenciadorContato dadosContatos = new GerenciadorContato();

    @Test
    public void shouldAddContato() {
        Contato contatos = new Contato("Contato1", 1);
        dadosContatos.cadastroContato(contatos);
        assertEquals(1,dadosContatos.listarContatos());
    }

    @Test
    public void shouldRemoveContato() {
        dadosContatos.removerContato("Contato1");
        assertEquals(0,dadosContatos.listarContatos());
    }

    @Test
    public void shouldSearchByName() {
        Contato contatos = new Contato("Contato1", 1);
        dadosContatos.cadastroContato(contatos);
        assertEquals(1,dadosContatos.buscarPorNome("Contato1"));
    }

    @Test
    public void shouldSearchByID() {
        assertEquals("Contato1",dadosContatos.buscarPorId(1));
    }

    @Test
    public void shouldListContatos() {
        assertEquals("Contato: Contato1 ID: 1", dadosContatos.listarContatos());
    }

}

