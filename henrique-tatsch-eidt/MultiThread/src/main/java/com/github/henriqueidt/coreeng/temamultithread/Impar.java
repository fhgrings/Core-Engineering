package com.github.henriqueidt.coreeng.temamultithread;
import java.util.Random;

public class Impar extends Thread {
    private final int REPETICOES_IMPAR = 50;

    private int geraImpar() {
        Random gerador = new Random();
        int calculaImpar = gerador.nextInt(1000) * 2 + 1;
        return calculaImpar;
    }

    @Override
    public void run() {

        for(int i=0; i<REPETICOES_IMPAR; i++){
            System.out.println("Thread Impar: " + geraImpar());
            try { Thread.sleep(100); } catch(Exception e) {}
        }
    }
}
