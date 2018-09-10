package com.github.rafaritter44.core_eng.template.model;

public class ChocolateQuente extends BebidaQuente {

    @Override
    void preparar() {
        System.out.println("Preparando chocolate quente...");
    }

    @Override
    void esquentar() {
        System.out.println("Esquentando chocolate quente...");
    }

    @Override
    void servir() {
        System.out.println("Chocolate quente servido!");
    }

}
