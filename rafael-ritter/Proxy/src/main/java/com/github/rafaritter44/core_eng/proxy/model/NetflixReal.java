package com.github.rafaritter44.core_eng.proxy.model;

class NetflixReal implements Netflix {

    @Override
    public void assistirConteudoAdulto() {
        System.out.println("Baixando filme violento...");
    }

    @Override
    public void assistirConteudoInfantil() {
        System.out.println("Baixando desenho animado...");
    }

}
