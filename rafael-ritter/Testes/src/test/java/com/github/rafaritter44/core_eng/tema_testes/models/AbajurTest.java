package com.github.rafaritter44.core_eng.tema_testes.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbajurTest {

    @Test
    public void switchLampadaIncandescente() {
        Abajur abajur = new Abajur(new Incandescente());
        assertFalse(abajur.isOn());
        abajur.switchLampada();
        assertTrue(abajur.isOn());
        abajur.switchLampada();
        assertFalse(abajur.isOn());
    }

    @Test
    public void switchLampadaLED() {
        Abajur abajur = new Abajur(new LED());
        assertFalse(abajur.isOn());
        abajur.switchLampada();
        assertTrue(abajur.isOn());
        abajur.switchLampada();
        assertFalse(abajur.isOn());
    }
}