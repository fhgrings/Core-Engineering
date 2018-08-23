package com.github.walterolivos.core_eng.tema_1;

public class Interruptor {

    private boolean on = false;
    private Lampada lampada;

    public Interruptor(Lampada lampada){
        this.lampada = lampada;
    }

    boolean isOn(){
        if (on) {
            System.out.println("Lampada está ligada");
        } else {
            System.out.println("Lampada está desligada");
        }
        return on;
    }

    public void switchLampada() {
        if (on) {
            lampada.off();
            on = false;
            System.out.println("Lampada foi desligada");
        } else {
            lampada.on();
            on = true;
            System.out.println("Lampada foi ligada");
        }
    }

}
