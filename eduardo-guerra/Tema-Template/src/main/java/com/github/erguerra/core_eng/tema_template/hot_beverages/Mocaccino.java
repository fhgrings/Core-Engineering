package com.github.erguerra.core_eng.tema_template.hot_beverages;

public class Mocaccino extends HotBeverages {
    @Override
    public void putMilk() {
        System.out.println("Putting a lot of milk because this is a Moca");
    }

    @Override
    public void putCoffee() {
        System.out.println("Putting two gouts of coffee");
    }

    @Override
    public void putChocolate() {
        System.out.println("Putting lots of chocolate!! Hmmmmm nham nham!");
    }

    @Override
    public void putSugar() {
        System.out.println("Sugar not needed! Chocolate is sweet enough");
    }
}
