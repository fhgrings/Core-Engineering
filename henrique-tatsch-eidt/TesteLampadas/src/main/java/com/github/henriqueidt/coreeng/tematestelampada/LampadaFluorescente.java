package com.github.henriqueidt.coreeng.tematestelampada;

public class LampadaFluorescente implements Lampada {
    public boolean ligada;

    @Override
    public void on() {
        ligada = true;
    }

    @Override
    public void off() {
        ligada = false;
    }
}