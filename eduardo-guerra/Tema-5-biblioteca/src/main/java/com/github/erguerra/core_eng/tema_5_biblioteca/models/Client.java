package com.github.erguerra.core_eng.tema_5_biblioteca.models;


public class Client{
    private String id;
    private String name;
    private int allRentedBooks = 0;
    private int currentRents = 0;

    public Client(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAllRentedBooks(){
        return allRentedBooks;
    }

    public int getCurrentRents(){
        return currentRents;
    }

    public void returnABook(){
        if(currentRents > 0)
            currentRents--;
    }
    public void rentABook(){
        currentRents++;
        allRentedBooks++;
    }

    public void setAllRentedBooks(int allRentedBooks) {
        this.allRentedBooks = allRentedBooks;
    }

    public void setCurrentRents(int currentRents) {
        this.currentRents = currentRents;
    }
}
