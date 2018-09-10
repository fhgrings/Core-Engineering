package com.github.rafaritter44.core_eng.facade.app;

import com.github.rafaritter44.core_eng.facade.facade.SwApiFacade;

public class Main {

    public static void main(String args[]) {
        SwApiFacade facade = new SwApiFacade();
        System.out.println("<<<<<< SPECIES 1 >>>>>>\n" +
                facade.findSpeciesByID("1").get());
        System.out.println("<<<<<< SPECIES 6 >>>>>>\n" +
                facade.findSpeciesByID("6").get());
    }

}
