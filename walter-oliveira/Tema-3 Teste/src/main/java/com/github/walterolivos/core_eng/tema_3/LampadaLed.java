package com.github.walterolivos.core_eng.tema_3;

public class LampadaLed implements Lampada{

    private boolean on;

    public LampadaLed(){
        on = false;
    }

    public void on() {
        on = true;
        System.out.println("Lampada led foi ligada");
    }

    public void off() {
        on = false;
        System.out.println("Lampada led foi desligada");
    }


}