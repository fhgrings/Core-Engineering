package com.github.rafaritter44.core_eng.tema_interfaces.models;

public class Abajur {

    private Lampada lampada;
    private boolean ligado;

    public Abajur(Lampada lampada) {
        this.lampada = lampada;
        ligado = false;
    }

    public void switchLampada() {
        if(ligado) {
            lampada.off();
            ligado = false;
        } else {
            lampada.on();
            ligado = true;
        }
    }

}
