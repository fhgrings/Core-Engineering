package com.github.henriqueidt.coreeng.temafactory.factory;

import com.github.henriqueidt.coreeng.temafactory.produto.Animal;
import com.github.henriqueidt.coreeng.temafactory.produto.Cachorro;
import com.github.henriqueidt.coreeng.temafactory.produto.Gato;
import com.github.henriqueidt.coreeng.temafactory.produto.Galinha;

public class AnimalFactory {

    public Animal getAnimal(String especie) {
        switch (especie) {
            case "canino": return new Cachorro();
            case "felino": return new Gato();
            case "ave": return new Galinha();
            default: throw new RuntimeException("Nenhum animal faz este som!");
        }
    }
}
