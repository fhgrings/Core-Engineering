package com.github.fhgrings._facade;


public class Character {
    private String name;
    private String height;
    private String mass;
    private String skin_color;
    private String gender;
    private String homeworld;


    @Override
    public String toString() {
        return "Name: " + name +
                "\nSkin Color: " + skin_color +
                "\nGender: " + gender +
                "\nMass: " + mass +
                "\nHeight: " + height +
                "\nHomeworld: " + homeworld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }
}