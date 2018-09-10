package com.github.rafaritter44.core_eng.template.model;

public abstract class BebidaQuente {

    abstract void preparar();
    abstract void esquentar();
    abstract void servir();

    public final void fazerBebida() {
        preparar();
        esquentar();
        servir();
    }

}
