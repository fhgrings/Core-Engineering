package com.github.walterolivos.core_eng.tema_3;

import org.junit.Assert;
import org.junit.Test;

public class LampadaTest {

    @Test
    public void testeLigado(){

        LampadaLed teste1 = new LampadaLed();
        LampadaFluorescente teste2 = new LampadaFluorescente();
        Interruptor teste3 = new Interruptor(teste1);
        Interruptor teste4 = new Interruptor(teste2);

        Assert.assertEquals(false, teste3.isOn());
        Assert.assertEquals(false, teste4.isOn());

    }

    @Test
    public void testeSwitch(){

        LampadaLed teste5 = new LampadaLed();
        LampadaFluorescente teste6 = new LampadaFluorescente();
        Interruptor teste7 = new Interruptor(teste5);
        Interruptor teste8 = new Interruptor(teste6);

        teste7.switchLampada();
        teste8.switchLampada();

        Assert.assertEquals(true, teste7.isOn());
        Assert.assertEquals(true, teste8.isOn());

    }

}
