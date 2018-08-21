package com.github.tema_1_threads;

public class ThreadImpar extends Thread {
    String tipo;
    int tempo;


    public ThreadImpar(String tipo, int tempo) {
        this.tempo = tempo;
        this.tipo = tipo;
    }

    public void run() {
        try {
            while (true) {
                if (tipo == "impar") {
                    int x=(int) (Math.random()*100);
                    x += (x%2==0?1:0);
                    System.out.println("Thread A #" + tipo + " " + x);
                }
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
