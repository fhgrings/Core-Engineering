package com.github.rafaritter44.core_eng.factory.model;

import com.github.rafaritter44.core_eng.factory.exceptions.SaborNaoInformadoException;

public class FabricaDeChocolate {

    public Chocolate getChocolate(Sabor sabor) {
        switch(sabor) {
            case BRANCO: return new ChocolateBranco();
            case AO_LEITE: return new ChocolateAoLeite();
            case AMARGO: return new ChocolateAmargo();
            default: throw new SaborNaoInformadoException("Por favor, informe o sabor do chocolate desejado!");
        }
    }

}
