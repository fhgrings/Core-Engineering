package com.github.rafaritter44.core_eng.factory.model;

public class ChocolateAoLeite implements Chocolate {

    private boolean jaFoiComido;

    public ChocolateAoLeite() {
        jaFoiComido = false;
    }

    @Override
    public void comer() {
        if(jaFoiComido) {
            System.out.println("Esse chocolate ao leite já foi comido!");
        } else {
            System.out.println("Humm... Que chocolate ao leite delicioso!!!");
            jaFoiComido = true;
        }
    }

}
