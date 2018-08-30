package com.github.walterolivos.core_eng.tema_5;

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


    public String contactInfos() {
        return ("Contact: " + name + " ID: " + id+"\n");
    }
}
