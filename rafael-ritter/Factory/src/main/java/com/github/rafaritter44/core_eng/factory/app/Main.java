package com.github.rafaritter44.core_eng.factory.app;

import com.github.rafaritter44.core_eng.factory.model.Chocolate;
import com.github.rafaritter44.core_eng.factory.model.FabricaDeChocolate;
import com.github.rafaritter44.core_eng.factory.model.Sabor;

public class Main {

    public static void main(String args[]) {
        FabricaDeChocolate fabrica = new FabricaDeChocolate();

        Chocolate chocolateBraco = fabrica.getChocolate(Sabor.BRANCO);
        chocolateBraco.comer();
        chocolateBraco.comer();
        chocolateBraco.comer();

        Chocolate chocolateAoLeite = fabrica.getChocolate(Sabor.AO_LEITE);
        chocolateAoLeite.comer();
        chocolateAoLeite.comer();
        chocolateAoLeite.comer();

        Chocolate chocolateAmargo = fabrica.getChocolate(Sabor.AMARGO);
        chocolateAmargo.comer();
        chocolateAmargo.comer();
        chocolateAmargo.comer();
    }

}
