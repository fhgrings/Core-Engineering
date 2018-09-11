package com.github.henriqueidt.coreeng.temafacade.main;

import com.github.henriqueidt.coreeng.temafacade.facade.HPFacade;

public class Main {

    public static void main(String[] args) {

        HPFacade hp = new HPFacade();
        System.out.println(hp.getHPCharacters());
    }
}
