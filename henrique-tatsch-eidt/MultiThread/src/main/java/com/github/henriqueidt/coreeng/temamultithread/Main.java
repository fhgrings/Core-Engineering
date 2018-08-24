package com.github.henriqueidt.coreeng.temamultithread;

public class Main {
    public static void main(String[] args) {
        Impar impar = new Impar();
        Par par = new Par();

        impar.start();
        par.start();
    }
}
