package com.github.rafaritter44.core_eng.tema_interfaces.models;

public class LED implements Lampada {

    public LED() {
        off();
    }

    public void on() { System.out.println("A lâmpada LED está ligada"); }

    public void off() { System.out.println("A lâmpada LED está desligada"); }
}
