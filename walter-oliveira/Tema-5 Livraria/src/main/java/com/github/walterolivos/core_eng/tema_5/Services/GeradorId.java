package com.github.walterolivos.core_eng.tema_5.Services;

public class GeradorId {

    public Integer numeroId;

    public GeradorId(Integer numeroId){
        this.numeroId = numeroId;
    }

    public synchronized String gerarId(){
        numeroId++;
        return numeroId.toString();
    }

    public  String getIdAtual(){
        return numeroId.toString();
    }
}
