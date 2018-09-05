package com.github.erguerra.core_eng.tema_5_biblioteca.services;


import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Rent{

    private String clientId;
    private String bookId;
    private LocalDate rentDate;
    private final int PENALTY = 5;
    private final int LIMIT = 7;


    public Rent(String clientId, String bookId){
        this.clientId = clientId;
        this.bookId = bookId;
        this.rentDate = LocalDate.now();
    }

    public LocalDate getRentDate(){
        return this.rentDate;
    }

    public void setRentDate(LocalDate localDate){
        this.rentDate = localDate;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getClientId() {
        return this.clientId;
    }

    public int getDaysOfLate(){
        long daysOfLate = DAYS.between(rentDate, LocalDate.now()) - LIMIT;
        if(daysOfLate > 0){
            return (int)daysOfLate;
        }
        else
            return 0;
    }
    public int getPenalty(){
        return getDaysOfLate() * PENALTY;
    }
    public boolean isLate(){
        return getDaysOfLate() > 0;
    }



    public boolean renewRent(){
        this.rentDate = LocalDate.now();
        return true;
    }





}
