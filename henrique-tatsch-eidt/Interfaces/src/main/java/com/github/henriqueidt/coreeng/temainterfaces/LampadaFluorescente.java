package com.github.henriqueidt.coreeng.temainterfaces;

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
