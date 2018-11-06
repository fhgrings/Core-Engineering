package com.github.fhgrings._facade;

public class Main {
    public static void main(String[] args) {
        SwapiFacade swapiFacade = new SwapiFacade();

        System.out.println("==== First Character ====");
        System.out.println(swapiFacade.findCharacterById(1));

        System.out.println("==== Second Character ====");
        System.out.println(swapiFacade.findCharacterById(3));
    }
}
