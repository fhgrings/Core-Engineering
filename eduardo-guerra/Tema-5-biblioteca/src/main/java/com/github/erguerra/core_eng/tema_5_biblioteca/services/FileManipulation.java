package com.github.erguerra.core_eng.tema_5_biblioteca.services;

import com.github.erguerra.core_eng.tema_5_biblioteca.models.Book;
import com.github.erguerra.core_eng.tema_5_biblioteca.models.Client;
import com.github.erguerra.core_eng.tema_5_biblioteca.models.Library;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class FileManipulation {

    private String booksToWrite(List<Book> books){
        String textToWrite = "";
        for(Book b: books){
            textToWrite += b.getId() + "%" + b.getTitle() + "%" + b.getAuthor() + "%" + b.isRented() + "%\n";
        }
        return textToWrite;
    }
    private String clientsToWrite(List<Client> clients){
        String textToWrite = "";

        for(Client c: clients){
            textToWrite += c.getId() + "#" + c.getName() + "#" + c.getAllRentedBooks() +
                    "#" + c.getCurrentRents() + "#\n";
        }
        return textToWrite;
    }
    private String rentsToWrite(List<Rent> rents){
        String textToWrite = "";
        for(Rent r: rents){
            textToWrite += r.getClientId() + "@" + r.getBookId() + "@" + r.getRentDate() + "@\n";
        }

        return textToWrite;
    }
    public boolean writeLibrary(String fileName, Library library){


        try(FileWriter file = new FileWriter(fileName, false)){

            PrintWriter writeFile = new PrintWriter(file);
            String text = "";

            text += String.valueOf(library.getNextId())+";\n";
            text += booksToWrite(library.getRegisteredBooks());
            text += clientsToWrite(library.getRegisteredClients());
            text += rentsToWrite(library.getRents());
            writeFile.write(text);
            return true;

        }catch(IOException ioEx){
            System.out.println(ioEx.getMessage());
            return false;
        }

    }


    private Book readBook(String fileContent){

        String[] contentSplited = fileContent.split("%");
        String id = contentSplited[0];
        String title = contentSplited[1];
        String author = contentSplited[2];
        boolean rented = false;
        boolean late = false;

        if(contentSplited[3].equals("true")){
            rented = true;
        }
        Book book = new Book(id, title, author);
        book.setRented(rented);

        return book;
    }
    private Client readClient(String fileContent){

        String id = fileContent.split("#")[0];
        String name = fileContent.split("#")[1];
        int allRentedBooks = parseInt(fileContent.split("#")[2]);
        int currentRentedBooks = parseInt(fileContent.split("#")[3]);

        Client client = new Client(id, name);
        client.setAllRentedBooks(allRentedBooks);
        client.setCurrentRents(currentRentedBooks);

        return client;
    }

    private Rent readRent(String fileContent){
        String clientId = fileContent.split("@")[0];
        String bookId = fileContent.split("@")[1];
        LocalDate localDate = LocalDate.parse(fileContent.split("@")[2]);
        Rent rent = new Rent(clientId, bookId);
        rent.setRentDate(localDate);

        return rent;
    }
    private int readNextId (String fileContent){
        int nextId = 0;
        nextId = Integer.parseInt(fileContent.split(";")[0]);
        return nextId;
    }



    public void readLibrary(String fileName, Library library){
        List<Book> books = new ArrayList<>();
        List<Rent> rents = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        int nextId = 0;

        try(FileReader file = new FileReader(fileName)){
            BufferedReader readFile = new BufferedReader(file);
            String line = "";

            line = readFile.readLine();
            while(line!= null){
                if(line.contains(";"))
                    nextId = readNextId(line);
                else if(line.contains("%"))
                    books.add(readBook(line));
                else if(line.contains("#"))
                    clients.add(readClient(line));
                else if(line.contains("@"))
                    rents.add(readRent(line));
                line = readFile.readLine();
            }

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            rents.clear();
        }

        library.setNextId(nextId);
        library.setRegisteredBooks(books);
        library.setRegisteredClients(clients);
        library.setRents(rents);
    }




}
