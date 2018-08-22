package com.github.rafaritter44.core_eng.tema_interfaces.models;

public class Incandescente implements Lampada {

    public Incandescente() {
        off();
    }

    public void on() { System.out.println("A lâmpada incandescente está ligada"); }

    public void off() { System.out.println("A lâmpada incandescente está desligada"); }

}
