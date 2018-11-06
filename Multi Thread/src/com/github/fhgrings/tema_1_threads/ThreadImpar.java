package com.github.fhgrings.tema_1_threads;

public class ThreadImpar extends Thread {

    public void run() {
        try {
            while (true) {
                System.out.println("Thread Impar #" + gerarNumero());
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    private int gerarNumero() {
        int x = (int) (Math.random() * 100);
        x += (x % 2 == 0 ? 1 : 0);
        return x;
    }
}
