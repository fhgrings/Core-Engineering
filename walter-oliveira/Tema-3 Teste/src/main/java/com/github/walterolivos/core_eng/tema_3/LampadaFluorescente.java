package com.github.walterolivos.core_eng.tema_3;

public class LampadaFluorescente implements Lampada{

    private boolean on;

    public LampadaFluorescente(){
        on = false;
    }

    public void on() {
        on = true;
        System.out.println("Lampada fluorescente foi ligada");
    }

    public void off() {
        on = false;
        System.out.println("Lampada fluorescente foi desligada");
    }


}
