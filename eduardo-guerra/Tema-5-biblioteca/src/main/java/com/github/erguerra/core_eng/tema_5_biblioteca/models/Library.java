package com.github.erguerra.core_eng.tema_5_biblioteca.models;

import com.github.erguerra.core_eng.tema_5_biblioteca.exceptions.InvalidIdException;
import com.github.erguerra.core_eng.tema_5_biblioteca.services.Rent;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library{

    private List<Book> registeredBooks = new ArrayList<>();
    private List<Client> registeredClients = new ArrayList<>();
    private List<Rent> rents =  new ArrayList<>();
    private int nextId = 0;
    private final int RENT_LIMIT = 5;

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public List<Book> getRegisteredBooks() {
        return registeredBooks;
    }

    public List<Client> getRegisteredClients() {
        return registeredClients;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRegisteredBooks(List<Book> books){
        this.registeredBooks = books;
    }
    public void setRegisteredClients(List<Client> clients){
        this.registeredClients = clients;
    }
    public void setRents(List<Rent> rents){
        this.rents = rents;
    }


    public String showAllBooks(){
        if(registeredBooks.isEmpty())
            return "No book registered";
        String allBooksString = "";
        for(int i = 0; i<registeredBooks.size(); i++){
            allBooksString = allBooksString.concat(registeredBooks.get(i).showBookInformation());
        }
        return allBooksString;
    }

     public boolean registerBook(String title, String author){
        Book book = new Book(String.valueOf(nextId), title, author);
        nextId++;
        return registeredBooks.add(book);
    }


     public Book searchBookById(String id) throws InvalidIdException {
       for(Book book : registeredBooks){
           if(book.getId().equals(id))
               return book;
       }
       throw new InvalidIdException("InvalidId exception");
    }
    public Client searchClientById(String id) throws InvalidIdException{
        for(Client client : registeredClients){
            if(client.getId().equals(id)){
                return client;
            }
        }
        throw new InvalidIdException("InvalidId exception");
    }

    public List<Book> searchBookByTitle(String title){
        List<Book> matchResults = new ArrayList<>();

        for(Book book : registeredBooks){
            if(book.getTitle().equals(title)){
                matchResults.add(book);
            }
        }
        return matchResults;
    }

    public List<Book> searchBookByAuthor(String author){
        List<Book> matchResults = new ArrayList<>();

        for(Book book : registeredBooks){
            if(book.getAuthor().equals(author)){
                matchResults.add(book);
            }
        }
        return matchResults;
    }

    public String showSpecificBooks(List<Book> books){
        if(books.isEmpty())
            return "No book found\n";
        String allBooksString = "";
        for(Book book : books){
            allBooksString = allBooksString.concat(book.showBookInformation());
        }
        return allBooksString;
    }


    public boolean removeBookById(String id){
        if(registeredBooks.isEmpty())
            return false;

        try{
            Book book = searchBookById(id);
            return registeredBooks.remove(book);
        }catch(InvalidIdException invalidIdException){
            System.out.println(invalidIdException.getMessage());
            return false;
        }

    }

    public boolean rentBook(String clientId, String bookId){

        if(registeredClients.isEmpty() || registeredClients.isEmpty())
            return false;
        try{
            Client client = searchClientById(clientId);
            Book book = searchBookById(bookId);

            if(book.isRented() || client.getCurrentRents() >= RENT_LIMIT){
                return false;
            }
            client.rentABook();
            book.setRented(true);
            return rents.add(new Rent(clientId, bookId));
        }catch(InvalidIdException invalidIdException){
            System.out.println(invalidIdException.getMessage());
            return false;
        }

    }

    public int returnBooks(String clientId, List<String> bookIds){

        int penalty = 0;

        try{
            Client client = searchClientById(clientId);
            for(String id : bookIds){
                for(Rent rent : rents){
                    if(clientId.equals(rent.getClientId()) && id.equals(rent.getBookId())){
                        Book book = searchBookById(id);
                        penalty += rent.getPenalty();
                        book.setRented(false);
                        client.returnABook();
                        rents.remove(rent);
                        return penalty;
                    }
                }
            }
        }catch(InvalidIdException invalidIdException){
            System.out.println(invalidIdException.getMessage());
        }finally {
            return penalty;
        }

    }

    public boolean renewRent(String clientId, String bookId){

        try{
            Client client = searchClientById(clientId);
            if(allLateClients().contains(client)) {
                return false;
            }
            else {
                return findRent(clientId, bookId).renewRent();
            }
        }catch(InvalidIdException invalidIdException){
            System.out.println(invalidIdException.getMessage());
            return false;
        }

    }

    private Rent findRent(String clientId, String bookId){
        for(Rent rent : rents){
            if(rent.getBookId().equals(bookId) && rent.getClientId().equals(clientId)){
                return rent;
            }
        }
        return null;
    }

    public String showRentedBooks(){
        if(rents.isEmpty())
            return "No book rented";
        String rentedBooksInfo = "";
        for(Book book: rentedBooks()){
            for(Rent rent: rents){
                if(book.getId().equals(rent.getBookId())){
                    try{
                        Client client = searchClientById(rent.getClientId());
                        rentedBooksInfo = rentedBooksInfo.concat(book.getId() + " " + book.getTitle() + " " + client.getId() + " " + client.getName() + "\n");
                    }catch(InvalidIdException invalidIdException){
                        System.out.println(invalidIdException.getMessage());
                    }
                }
            }
        }
        return rentedBooksInfo;
    }

    public List<Book> rentedBooks(){
        List<Book> rentedBooks = new ArrayList<>();

        for(Book book : registeredBooks){
            if(book.isRented())
                rentedBooks.add(book);
        }
        return rentedBooks;
    }

    public String topTenCostumers(){
        Collections.sort(registeredClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return Integer.valueOf(o2.getAllRentedBooks()).compareTo(o1.getAllRentedBooks());
            }
        });

        String topClients = "";

        if(registeredClients.size() > 10){
            for(int i = 0; i < 10; i++){
                topClients = topClients.concat(registeredClients.get(i).getId() + " " + registeredClients.get(i).getName() + "\n");
            }
        }else
            for(Client c: registeredClients){
                topClients = topClients.concat(c.getId() + " " + c.getName() + "\n");
            }

        return topClients;
    }

    public String showAllLateClients(){

        String lateClients = "";
        for(Rent rent : rents){
            if(rent.isLate()){
                lateClients = lateClients.concat("Client Id: " + rent.getClientId() + " Days of Late: " + rent.getDaysOfLate() + "\n");
            }
        }
        if(!lateClients.isEmpty()){
            return lateClients;
        }else{
            return "No late client\n";
        }
    }

    public List<Client> allLateClients(){

        List<Client> lateClients = new ArrayList<>();
        for(Rent rent : rents){
            if(rent.isLate()){
                try{
                    lateClients.add(searchClientById(rent.getClientId()));
                }catch(InvalidIdException invalidIdException){
                    System.out.println(invalidIdException);
                }
            }
        }
        return lateClients;
    }
}

