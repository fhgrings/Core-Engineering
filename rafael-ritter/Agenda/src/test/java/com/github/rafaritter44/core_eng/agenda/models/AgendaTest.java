package com.github.rafaritter44.core_eng.agenda.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgendaTest {

    private Agenda agenda;

    @Before
    public void setup() {
        agenda = new Agenda();
        agenda.add("Rafael", "9991-8881");
        agenda.add("Maria", "9000-8000");
        agenda.add("João da Silva", "9405-2325");
    }

    @Test
    public void add() {
        String esperado = "Nome: Tarzan | Telefone: 1234-5678";
        agenda.add("Tarzan", "1234-5678");
        String real = agenda.get(3).toString();
        assertEquals(esperado, real);
    }

    @Test
    public void remove() {
        Contato esperado = agenda.get(2);
        Contato real = agenda.remove(2);
        assertEquals(esperado, real);
        assertNull(agenda.remove(2));
    }

    @Test
    public void toStringTest() {
        String esperado = "Lista de Contatos:\n" +
                "Nome: Rafael | Telefone: 9991-8881\n" +
                "Nome: Maria | Telefone: 9000-8000\n" +
                "Nome: João da Silva | Telefone: 9405-2325\n";
        String real = agenda.toString();
        assertEquals(esperado, real);
    }

    @Test
    public void getPorNome() {
        String esperado = "Nome: Rafael | Telefone: 9991-8881";
        String real = agenda.get("Rafael").toString();
        assertEquals(esperado, real);
        assertNull(agenda.get("Luizinho"));
        assertNull(agenda.get(null));
    }

    @Test
    public void getPorId() {
        String esperado = "Nome: João da Silva | Telefone: 9405-2325";
        String real = agenda.get(2).toString();
        assertEquals(esperado, real);
        agenda.remove(1);
        real = agenda.get(2).toString();
        assertEquals(esperado, real);
        assertNull(agenda.get(-1));
        assertNull(agenda.get(3));
    }
}