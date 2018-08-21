package com.github.tema_1_threads;

public class ThreadPar extends Thread {
    String tipo;
    int tempo;


    public ThreadPar(String tipo, int tempo) {
        this.tempo = tempo;
        this.tipo = tipo;
    }

    public void run() {
        try {
            while (true) {
                if (tipo == "par") {
                    int x=(int) (Math.random()*50);
                    x = (x*2);
                    System.out.println("Thread B #" + tipo + " " + x);
                }
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
