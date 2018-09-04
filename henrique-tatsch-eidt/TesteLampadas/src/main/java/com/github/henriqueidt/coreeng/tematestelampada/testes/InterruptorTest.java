package com.github.henriqueidt.coreeng.tematestelampada.testes;
import com.github.henriqueidt.coreeng.tematestelampada.Lampada;
import com.github.henriqueidt.coreeng.tematestelampada.LampadaFluorescente;
import com.github.henriqueidt.coreeng.tematestelampada.LampadaIncandescente;
import com.github.henriqueidt.coreeng.tematestelampada.Interruptor;
import org.testng.annotations.Test;
import org.junit.Assert;

public class InterruptorTest {

    @Test
    public void testaIncandescenteOFF() {
        Lampada lampadaTest = new LampadaFluorescente();
        Interruptor interruptorTest = new Interruptor(lampadaTest);

        Assert.assertFalse(interruptorTest.isOn());
    }

    @Test
    public void testaFluorescenteOFF() {
        Lampada lampadaTest = new LampadaIncandescente();
        Interruptor interruptorTest = new Interruptor(lampadaTest);

        Assert.assertFalse(interruptorTest.isOn());
    }

    @Test
    public void testaSwitchOFF() {
        Lampada lampadaTest = new LampadaFluorescente();
        Interruptor interruptorTest = new Interruptor(lampadaTest);

        interruptorTest.inverter();
        System.out.println("A lampada foi setada como " + interruptorTest.isOn());
        interruptorTest.inverter();
        Assert.assertFalse(interruptorTest.isOn());

    }

    @Test
    public void testaSwitchON() {
        Lampada lampadaTest = new LampadaIncandescente();
        Interruptor interruptorTest = new Interruptor(lampadaTest);

        interruptorTest.inverter();

        Assert.assertTrue(interruptorTest.isOn());
    }
}
