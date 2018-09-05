package com.github.erguerra.core_eng.tema_5_biblioteca.models;



public class Book{
    private String id;
    private String title;
    private String author;
    private boolean rented = false;



    public Book(String id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public String showBookInformation(){
        if(rented){
            return (id + " " + title + " " + author + " rented\n");
        }else
            return (id + " " + title + " " + author + " available\n");

    }


}
