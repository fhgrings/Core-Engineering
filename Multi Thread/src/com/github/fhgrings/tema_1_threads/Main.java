package com.github.fhgrings.tema_1_threads;

public class Main {

    public static void main (String[] args) {

        ThreadPar threadPar = new ThreadPar();
        ThreadImpar threadImpar = new ThreadImpar();

        threadImpar.start();
        threadPar.start();
    }
}
