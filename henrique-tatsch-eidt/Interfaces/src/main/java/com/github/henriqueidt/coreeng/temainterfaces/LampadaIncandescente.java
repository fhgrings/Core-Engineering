package com.github.henriqueidt.coreeng.temainterfaces;

public class LampadaIncandescente implements Lampada {
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
