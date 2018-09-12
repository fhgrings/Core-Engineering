package com.github.erguerra.core_eng.tema_template.app;

import com.github.erguerra.core_eng.tema_template.hot_beverages.Latte;
import com.github.erguerra.core_eng.tema_template.hot_beverages.Mocaccino;

public class Main {
    public static void main(String[] args) {
        Latte latte = new Latte();
        Mocaccino mocaccino = new Mocaccino();

        latte.makeHotBeverage();
        System.out.println("----------------------------------------------------------------");
        mocaccino.makeHotBeverage();
    }
}
