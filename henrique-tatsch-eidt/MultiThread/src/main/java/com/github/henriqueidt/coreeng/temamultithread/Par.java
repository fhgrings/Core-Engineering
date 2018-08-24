package com.github.henriqueidt.coreeng.temamultithread;
import java.util.Random;

public class Par extends Thread {
    private final int REPETICOES_PAR = 50;

    private int geraPar() {
        Random gerador = new Random();
        int calculaPar = gerador.nextInt(1000) * 2;
        return calculaPar;
    }

    @Override
    public void run() {

        for(int i=0; i<REPETICOES_PAR; i++){
            System.out.println("Thread par: " + geraPar());
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
