package com.github.erguerra.core_eng.tema_template.hot_beverages;

public abstract class HotBeverages {
    public abstract void putMilk();

    public abstract void putCoffee();

    public abstract void putChocolate();

    public abstract void putSugar();

    public void makeHotBeverage() {
        putMilk();
        putCoffee();
        putChocolate();
        putSugar();
    }


}
