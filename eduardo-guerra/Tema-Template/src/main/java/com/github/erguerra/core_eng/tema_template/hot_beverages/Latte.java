package com.github.erguerra.core_eng.tema_template.hot_beverages;

public class Latte extends HotBeverages {

    @Override
    public void putMilk() {
        System.out.println("Putting a lot of milk because this is a latte");
    }

    @Override
    public void putCoffee() {
        System.out.println("Putting a gout of coffee");
    }

    @Override
    public void putChocolate() {
        System.out.println("Skip this part! No chocolate here!");
    }

    @Override
    public void putSugar() {
        System.out.println("Putting some sugar");
    }
}
