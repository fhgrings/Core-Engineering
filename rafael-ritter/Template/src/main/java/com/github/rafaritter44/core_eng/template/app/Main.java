package com.github.rafaritter44.core_eng.template.app;

import com.github.rafaritter44.core_eng.template.model.BebidaQuente;
import com.github.rafaritter44.core_eng.template.model.ChocolateQuente;
import com.github.rafaritter44.core_eng.template.model.Quentao;

public class Main {

    public static void main(String args[]) {
        BebidaQuente bebidaQuente = new ChocolateQuente();
        bebidaQuente.fazerBebida();

        bebidaQuente = new Quentao();
        bebidaQuente.fazerBebida();
    }

}
