package com.github.rafaritter44.core_eng.proxy.app;

import com.github.rafaritter44.core_eng.proxy.model.Netflix;
import com.github.rafaritter44.core_eng.proxy.model.NetflixProxy;

public class Main {

    public static void main(String args[]) {
        Netflix netflixPai = new NetflixProxy("papai", "1234");
        netflixPai.assistirConteudoInfantil();
        netflixPai.assistirConteudoAdulto();
        Netflix netflixFilho = new NetflixProxy("juninho", "0000");
        netflixFilho.assistirConteudoInfantil();
        netflixFilho.assistirConteudoAdulto();
    }

}
