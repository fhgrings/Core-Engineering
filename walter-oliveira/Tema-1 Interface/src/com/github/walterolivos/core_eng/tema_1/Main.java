package com.github.walterolivos.core_eng.tema_1;

public class Main {

    public static void main(String[]  args) {

        LampadaLed lampadaLed = new LampadaLed();
        LampadaFluorescente lampadaFluorescente = new LampadaFluorescente();

        Interruptor interruptorLed = new Interruptor(lampadaLed);
        Interruptor interruptorFluorescente = new Interruptor(lampadaFluorescente);

        interruptorLed.isOn();
        interruptorFluorescente.isOn();

        interruptorLed.switchLampada();
        interruptorFluorescente.switchLampada();

    }
    
}
