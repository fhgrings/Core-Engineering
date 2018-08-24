package com.github.rafaritter44.core_eng.tema_multithreading.models;

import java.util.Random;

public class ThreadPar extends Thread {

    private Random gerador;
    private static final int INTERVALO = 500;

    public ThreadPar() {
        gerador = new Random();
    }

    public void run() {
        while(true) {
            System.out.println(geraPar());
            try {
                Thread.sleep(INTERVALO);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int geraPar() { return gerador.nextInt(50) * 2; }

}
