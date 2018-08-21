package com.github.fhgrings.tema_1_threads;

public class Main {

    public static void main (String[] args) {

        ThreadPar threadPar = new ThreadPar("par", 500);
        ThreadImpar threadImpar = new ThreadImpar("impar", 100);

        threadImpar.start();
        threadPar.start();
    }

}
