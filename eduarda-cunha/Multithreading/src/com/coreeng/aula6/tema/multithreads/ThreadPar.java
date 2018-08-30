package com.coreeng.aula6.tema.multithreads;

public class ThreadPar extends Thread{

    public void run() {
        for (int j = 0; j <= 20; j++) {
            System.out.println("Thread Par" + " contador " + gerarPar());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread Par execução terminada");
    }

    public int gerarPar(){
        int aleatorioPar;

        aleatorioPar = (int) (Math.random() * 50);
        aleatorioPar = (aleatorioPar * 2);
        return aleatorioPar;
    }

}
