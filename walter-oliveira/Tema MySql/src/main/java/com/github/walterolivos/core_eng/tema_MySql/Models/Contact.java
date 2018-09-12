package com.github.walterolivos.core_eng.tema_MySql.Models;

public class Contact {

    private String name;
    private int id;

    public Contact (String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
