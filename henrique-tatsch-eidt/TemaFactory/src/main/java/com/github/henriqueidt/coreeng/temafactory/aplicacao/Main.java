package com.github.henriqueidt.coreeng.temafactory.aplicacao;

import com.github.henriqueidt.coreeng.temafactory.factory.AnimalFactory;
import com.github.henriqueidt.coreeng.temafactory.produto.Animal;

public class Main {

    public static void main(String args[]) {
        AnimalFactory factory = new AnimalFactory();

        Animal latindo = factory.getAnimal("canino");
        latindo.bicho();
        Animal miando = factory.getAnimal("felino");
        miando.bicho();
        Animal cacarejando = factory.getAnimal("ave");
        cacarejando.bicho();
    }
}
