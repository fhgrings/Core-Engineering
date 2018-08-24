package com.github.henriqueidt.coreeng.temainterfaces;

public class Main {

    public static void main(String args[]) {
        Lampada led = new LampadaIncandescente();
        Interruptor interruptor = new Interruptor(led);


        System.out.println(Interruptor.isOn());
        interruptor.inverter();
        System.out.println(Interruptor.isOn());
    }
}
