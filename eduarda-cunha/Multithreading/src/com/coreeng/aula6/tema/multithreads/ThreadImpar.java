package com.coreeng.aula6.tema.multithreads;

public class ThreadImpar extends Thread{

    public void run() {
        for (int j = 0; j <= 20; j++) {
            System.out.println("Thread Impar" + " contador " + gerarImpar());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread Impar" + " execução terminada");
    }

    public int gerarImpar() {
        int aleatorioImpar;

        aleatorioImpar = (int) (Math.random() * 100);
        aleatorioImpar += (aleatorioImpar % 2 == 0 ? 1 : 0);
        return aleatorioImpar;
    }

}
