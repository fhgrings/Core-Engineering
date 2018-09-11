import com.github.mariaeduardacunha.tema4.agenda.model.Agenda;
import com.github.mariaeduardacunha.tema4.agenda.model.Contato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteAgenda {

    private Agenda dados = new Agenda();

    @Test
    public void shouldAdicionar(){
        Contato contato = new Contato("ContatoA", 1, "email@email.com", "51999999999");
        dados.adicionar(contato);
        assertEquals(1,dados.listar());
    }

    @Test
    public void shouldBuscarId(){
        Contato contato = new Contato("ContatoA", 1, "email@email.com", "51999999999");
        dados.adicionar(contato);
        assertEquals("ContatoA", dados.buscarId(1));
    }

    @Test
    public void shouldBuscarNome(){
        Contato contato = new Contato("ContatoA", 1, "email@email.com", "51999999999");
        dados.adicionar(contato);
        assertEquals(1, dados.buscarNome("ContatoA"));
    }

    @Test
    public void shouldListar(){
        Contato contato = new Contato("ContatoA", 1, "email@email.com", "51999999999");
        dados.adicionar(contato);
        assertEquals(1, dados.listar());
    }

    @Test
    public void shouldRemoverId() {
        Contato contato = new Contato("ContatoA", 1, "email@email.com", "51999999999");
        dados.adicionar(contato);
        dados.removerId(1);
        assertEquals(0, dados.listar());
    }

    @Test
    public void shouldRemoverNome(){
        Contato contato = new Contato("ContatoA", 1, "email@email.com", "51999999999");
        dados.adicionar(contato);
        dados.removerNome("ContatoA");
        assertEquals(0, dados.listar());
    }
}
