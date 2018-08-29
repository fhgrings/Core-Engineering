package com.github.mariaeduardacunha.core_eng.tema_1;

public class Led implements Lampada{

    private Boolean isOn = false;


    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }
}