package com.github.mariaeduardacunha.core_eng.tema_3.tests;

import com.github.mariaeduardacunha.core_eng.tema_3.Fluorescente;
import com.github.mariaeduardacunha.core_eng.tema_3.Interruptor;
import com.github.mariaeduardacunha.core_eng.tema_3.Lampada;
import com.github.mariaeduardacunha.core_eng.tema_3.Led;
import org.junit.Assert;
import org.junit.Test;

public class InterruptorTests {

    @Test
    public void interruptorTestsOn(){
        Led led = new Led();
        Interruptor interruptor = new Interruptor(led);

        Assert.assertEquals(true, interruptor.switchLampada());
    }
    @Test
    public void interruptorTestsOff(){
        Led led = new Led();
        Interruptor interruptor = new Interruptor(led);
        interruptor.switchLampada();
        Assert.assertEquals(false, interruptor.switchLampada());
    }

    @Test
    public void interruptorTestsOnFluor(){
        Fluorescente fluorescente = new Fluorescente();
        Interruptor interruptor = new Interruptor(fluorescente);

        Assert.assertEquals(true, interruptor.switchLampada());
    }
    @Test
    public void interruptorTestsOffFluor(){
        Fluorescente fluorescente = new Fluorescente();
        Interruptor interruptor = new Interruptor(fluorescente);
        interruptor.switchLampada();
        Assert.assertEquals(false, interruptor.switchLampada());
    }

}
