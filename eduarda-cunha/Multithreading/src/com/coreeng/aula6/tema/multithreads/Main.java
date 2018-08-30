package com.coreeng.aula6.tema.multithreads;

public class Main {

    public static void main(String[] args) {
        ThreadImpar thread = new ThreadImpar();

        ThreadPar thread2 = new ThreadPar();

        thread.start();
        thread2.start();
    }

}
