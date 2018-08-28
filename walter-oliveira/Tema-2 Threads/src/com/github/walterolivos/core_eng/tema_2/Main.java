package com.github.walterolivos.core_eng.tema_2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int TEMPO_IMPAR = 100;
    private static final int TEMPO_PAR = 500;

    public static void main(String[] args){

        Runnable threadImpares = () -> {

            for (int i = 0; i < 25; i++ ){
                System.out.println(gerarImpar());
                sleep(TEMPO_IMPAR);
            }
        };

        Runnable threadPares = () -> {

            for (int i = 0; i < 25; i++ ){
                System.out.println(gerarPar());
                sleep(TEMPO_PAR);
            }
        };

        Thread threadImpar = new Thread(threadImpares);
        threadImpar.start();

        Thread threadPar = new Thread(threadPares);
        threadPar.start();

    }

    public static void sleep(int tempo){

        try {
            TimeUnit.MILLISECONDS.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int gerarImpar(){
        int numero = 0;
        while (numero % 2 == 0){
            numero = ThreadLocalRandom.current().nextInt(50, 500);
        }
        return numero;
    }

    public static int gerarPar(){
        int numero = 1;
        while (numero % 2 != 0){
            numero = ThreadLocalRandom.current().nextInt(50, 500);
        }
        return numero;
    }



}
