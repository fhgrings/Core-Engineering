package com.github.henriqueidt.coreeng.tematemplate;

public class Bicicleta extends Veiculo {

    @Override
    void soldaPecas() {
        System.out.println("Quadro, pedais e demais peças da bicicleta soldados!");
    }

    @Override
    void pinta() {
        System.out.println("Bicicleta pintado de vermelho!");
    }

    @Override
    void colocaRodas() {
        System.out.println("2 rodas adicionadas a bicicleta!");
    }
}
