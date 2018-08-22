package com.github.fhgrings._lampada;

public class LED  implements Lampada {

    @Override
    public void on(){
        System.out.println("Diodo LED ligado ");
    }

    @Override
    public void off() {
        System.out.println("Diodo LED desligado ");
    }
}
