package com.github.mariaeduardacunha.core_eng.tema_3;

public class Interruptor {

    private Lampada lampada;
    private boolean isOn = false;

    public Interruptor(Lampada lampada){
        this.lampada = lampada;
    }

    public Boolean switchLampada(){
        if(isOn){
            lampada.off();
            isOn = false;
            return isOn;
        }else{
            lampada.on();
            isOn = true;
            return isOn;
        }

    }
}