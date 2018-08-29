package com.github.erguerra.core_eng.tema_4_agenda.models;

public class Contact {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(int id, String name, String phoneNumber, String email){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String showContactInformation(){
        return(this.id + " " + this.name + " " + this.phoneNumber + " " + this.email+ "\n");
    }

}
