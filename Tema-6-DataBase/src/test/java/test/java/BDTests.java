package test.java;

import com.github.fhgrings._agenda.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BDTests {

    private GerenciadorContato dadosContatos = new GerenciadorContato();

    @Test
    public void shouldAddContato() {
        Contato contatos = new Contato("Contato1",  "34731001", "kaka@kaka.com");
        assertEquals(true,dadosContatos.cadastrarContato(contatos));
    }

    @Test
    public void shouldRemoveContato() {
        dadosContatos.removerContato(1);
        assertEquals(true,dadosContatos.listarContatos());
    }

    @Test
    public void shouldSearchByName() {
        Contato contatos = new Contato("Contato1", "34731001", "kaka@kaka.com");
        dadosContatos.cadastrarContato(contatos);
        assertEquals(true,dadosContatos.buscarPorNome("Contato1"));
    }

    @Test
    public void shouldSearchByID() {
        assertEquals(true,dadosContatos.buscarPorId(1));
    }

    @Test
    public void shouldListContatos() {
        assertEquals(true, dadosContatos.listarContatos());
    }

}

