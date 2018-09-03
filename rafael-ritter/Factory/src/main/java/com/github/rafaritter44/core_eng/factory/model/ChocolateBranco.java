package com.github.rafaritter44.core_eng.factory.model;

public class ChocolateBranco implements Chocolate {

    private boolean jaFoiComido;

    public ChocolateBranco() {
        jaFoiComido = false;
    }

    @Override
    public void comer() {
        if(jaFoiComido) {
            System.out.println("Esse chocolate branco já foi comido!");
        } else {
            System.out.println("Humm... Que chocolate branco delicioso!!!");
            jaFoiComido = true;
        }
    }

}
