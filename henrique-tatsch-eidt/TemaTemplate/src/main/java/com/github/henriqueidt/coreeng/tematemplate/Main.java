package com.github.henriqueidt.coreeng.tematemplate;

public class Main {

    public static void main(String[] args) {
        Veiculo veiculo = new Carro();
        veiculo.monta();

        System.out.println();

        veiculo = new Bicicleta();
        veiculo.monta();
    }
}
