package com.github.walterolivos.core_eng.tema_3;

public class Main {

    public static void main(String[]  args) {

        LampadaLed lampadaled = new LampadaLed();
        LampadaFluorescente lampadafluorescente = new LampadaFluorescente();

        Interruptor gerencia1 = new Interruptor(lampadaled);
        Interruptor gerencia2 = new Interruptor(lampadafluorescente);

        gerencia1.switchLampada();
        gerencia2.switchLampada();

    }
    
}
