package com.github.rafaritter44.core_eng.tema_interfaces.models;

public class Abajur {

    private Lampada lampada;

    public Abajur(Lampada lampada) {
        this.lampada = lampada;
    }

    public void switchLampada() {
        if(lampada.isOn())
            lampada.off();
        else
            lampada.on();
    }

    public boolean isOn() { return lampada.isOn(); }

    public String tipo() {
        if(lampada instanceof LED)
            return "LED";
        else
            return "Incandescente";
    }

}
