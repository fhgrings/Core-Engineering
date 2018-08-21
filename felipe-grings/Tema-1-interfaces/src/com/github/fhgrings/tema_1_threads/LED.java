package com.github.fhgrings.tema_1_threads;

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
