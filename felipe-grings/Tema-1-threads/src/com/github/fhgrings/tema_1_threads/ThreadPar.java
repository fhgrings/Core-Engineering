package com.github.fhgrings.tema_1_threads;

public class ThreadPar extends Thread {

    public void run() {
        try {
            while (true) {
                System.out.println("Thread Par #" + gerarNumero());
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int gerarNumero() {
        int x = (int) (Math.random() * 50);
        x = (x * 2);
        return x;
    }
}
