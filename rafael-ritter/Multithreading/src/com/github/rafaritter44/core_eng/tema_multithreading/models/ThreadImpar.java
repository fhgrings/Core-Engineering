package com.github.rafaritter44.core_eng.tema_multithreading.models;

import java.util.Random;

public class ThreadImpar extends Thread {

    private Random gerador;
    private static int INTERVALO = 100;

    public ThreadImpar() {
        gerador = new Random();
    }

    public void run() {
        while(true) {
            System.out.println(geraImpar());
            try {
                Thread.sleep(INTERVALO);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int geraImpar() { return gerador.nextInt(50) * 2 + 1; }

}
