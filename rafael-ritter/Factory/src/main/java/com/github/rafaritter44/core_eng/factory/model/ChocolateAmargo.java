package com.github.rafaritter44.core_eng.factory.model;

public class ChocolateAmargo implements Chocolate {

    private boolean jaFoiComido;

    public ChocolateAmargo() {
        jaFoiComido = false;
    }

    @Override
    public void comer() {
        if(jaFoiComido) {
            System.out.println("Esse chocolate amargo já foi comido!");
        } else {
            System.out.println("Argh... Que chocolate mais amargo!!!");
            jaFoiComido = true;
        }
    }

}
