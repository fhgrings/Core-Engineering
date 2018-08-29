package com.github.mariaeduardacunha.core_eng.tema_3;

public class Main {

    public static void main(String[] args) {

        Led led = new Led();
        Fluorescente fluorescente = new Fluorescente();
        Interruptor interruptorLed = new Interruptor(led);
        Interruptor interruptorFluor = new Interruptor(fluorescente);

        if(interruptorFluor.switchLampada()){
            System.out.println("Fluorescente ligou");
        }
        if(!interruptorFluor.switchLampada()){
            System.out.println("Fluorescente desligou");
        }

        if(interruptorLed.switchLampada()){
            System.out.println("LED ligou");
        }
        if(interruptorLed.switchLampada()){
            System.out.println("LED desligou");
        }

    }
}