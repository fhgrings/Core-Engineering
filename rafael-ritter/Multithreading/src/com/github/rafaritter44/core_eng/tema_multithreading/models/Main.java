package com.github.rafaritter44.core_eng.tema_multithreading.models;

public class Main {
    public static void main(String args[]) {
        Thread threadPar = new ThreadPar();
        Thread threadImpar = new ThreadImpar();
        threadPar.start();
        threadImpar.start();
    }
}
