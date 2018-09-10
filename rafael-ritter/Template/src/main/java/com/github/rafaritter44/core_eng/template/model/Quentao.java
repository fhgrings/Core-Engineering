package com.github.rafaritter44.core_eng.template.model;

public class Quentao extends BebidaQuente {

    @Override
    void preparar() {
        System.out.println("Preparando quentão...");
    }

    @Override
    void esquentar() {
        System.out.println("Esquentando quentão...");
    }

    @Override
    void servir() {
        System.out.println("Quentão servido!");
    }

}
