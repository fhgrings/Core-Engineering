package com.github.fhgrings.tema_1_threads;

public class Incandescente implements Lampada {

    @Override
    public void on(){
        System.out.println("Lampada Incandescente ligada ");
    }

    @Override
    public void off() {
        System.out.println("Lampada Incandescente desligada ");
    }


}
