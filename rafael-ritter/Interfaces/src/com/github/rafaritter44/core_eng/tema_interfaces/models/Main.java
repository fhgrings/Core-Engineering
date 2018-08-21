package com.github.rafaritter44.core_eng.tema_interfaces.models;

public class Main {

    public static void main(String args[]) {

        Lampada lampada = new Incandescente();
        Abajur abajur = new Abajur(lampada);
        abajur.switchLampada();
        abajur.switchLampada();

        lampada = new LED();
        abajur = new Abajur(lampada);
        abajur.switchLampada();
        abajur.switchLampada();

    }

}
