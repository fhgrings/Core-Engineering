package com.github.henriqueidt.coreeng.tematemplate;

public class Carro extends Veiculo {

    @Override
    void soldaPecas() {
        System.out.println("Chassi, motor e peças do carro soldadas!");
    }

    @Override
    void pinta() {
        System.out.println("Carro pintado de branco!");
    }

    @Override
    void colocaRodas() {
        System.out.println("4 rodas adicionadas ao carro!");
    }
}
