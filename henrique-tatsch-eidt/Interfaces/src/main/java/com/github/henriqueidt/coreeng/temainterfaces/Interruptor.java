package com.github.henriqueidt.coreeng.temainterfaces;

public class Interruptor {
    private Lampada lampada;
    private static boolean acesa;

    public Interruptor(Lampada lampada) {
        this.lampada = lampada;
        this.acesa = false;
    }

    public void inverter() {
        if (acesa) {
            lampada.off();
            acesa = false;
        }  else {
            lampada.on();
            acesa = true;
           }
    }

    public static boolean isOn() {
        return acesa;
    }
}
