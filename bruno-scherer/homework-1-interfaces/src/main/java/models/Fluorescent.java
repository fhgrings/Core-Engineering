package models;

public class Fluorescent implements Lamp{
    @Override
    public void on() {
        System.out.println("Fluorescent Lights On!");
    }

    @Override
    public void off() {
        System.out.println("Fluorescent Lights Off!");
    }
}