package com.github.erguerra.core_eng.tema_5_biblioteca.app;

import com.github.erguerra.core_eng.tema_5_biblioteca.models.Library;
import com.github.erguerra.core_eng.tema_5_biblioteca.services.FileManipulation;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    final static int END_APPLICATION = 0;
    final static int REGISTER_BOOK = 1;
    final static int SHOW_ALL_BOOKS = 2;
    final static int SEARCH_BOOK_BY_TITLE = 3;
    final static int SEARCH_BOOK_BY_AUTHOR = 4;
    final static int REMOVE_BOOK_BY_ID = 5;
    final static int RENT_A_BOOK = 6;
    final static int RENEW_BOOK = 7;
    final static int RETURN_BOOKS = 8;
    final static int SHOW_RENTED_BOOKS = 9;
    final static int SHOW_TOP10_CLIENTS = 10;
    final static int SHOW_LATE_CLIENTS = 11;
    final static int SHOW_OPTIONS = 12;

    public static void main(String[] args){
        int menuOperation = 1;

        Library library = new Library();
        Scanner terminalScan = new Scanner(System.in);

        FileManipulation fm = new FileManipulation();

        String fileName = "library.txt";

        fm.readLibrary(fileName, library);

        showOptions();


        while(menuOperation != END_APPLICATION){

            menuOperation = terminalScan.nextInt();
            terminalScan.nextLine();


            switch(menuOperation){
                case REGISTER_BOOK:
                    System.out.println("Insert the title of the book");
                    String title = terminalScan.nextLine();
                    System.out.println("Insert the author of the book");
                    String author = terminalScan.nextLine();
                    if(library.registerBook(title, author))
                        System.out.println("Book registered successfully");
                    else
                        System.out.println("Book was not registered, check the inserted data");
                    break;
                case SHOW_ALL_BOOKS:
                    System.out.println(library.showAllBooks());
                    break;
                case SEARCH_BOOK_BY_TITLE:
                    System.out.println("Insert the title of the book");
                    System.out.println(library.showSpecificBooks(library.searchBookByTitle(terminalScan.nextLine())));
                    break;
                case SEARCH_BOOK_BY_AUTHOR:
                    System.out.println("Insert the name of the author");
                    System.out.println(library.showSpecificBooks(library.searchBookByAuthor(terminalScan.nextLine())));
                    break;
                case REMOVE_BOOK_BY_ID:
                    System.out.println("Insert the id of the book to remove");
                    if(library.removeBookById(terminalScan.next())){
                        System.out.println("Book removed");
                    }else
                        System.out.println("Book was not removed, check if the book is rented or if it isn't registered");
                    break;
                case RENT_A_BOOK:
                    System.out.println("Insert the id of the client");
                    String clientRentId = terminalScan.next();
                    System.out.println("Insert the id of the book");
                    String bookRentId = terminalScan.next();
                    if(library.rentBook(clientRentId, bookRentId))
                        System.out.println("Rent made with success");
                    else
                        System.out.println("Rent failed, check if the client is late or the book is already rented");
                    break;
                case RENEW_BOOK:
                    System.out.println("Insert the id of the client");
                    String clientRenewId = terminalScan.next();
                    System.out.println("Insert the id of the book");
                    String bookRenewId = terminalScan.next();
                    if(library.renewRent(clientRenewId, bookRenewId))
                        System.out.println("Rent updated successfully");
                    else
                        System.out.println("Renew failed, check if the client is late");
                    break;
                case RETURN_BOOKS:
                    System.out.println("Insert the id of the client");
                    String clientReturnId = terminalScan.next();
                    System.out.println("Insert the number of books");
                    int numberOfBooks = terminalScan.nextInt();
                    List<String> booksIds = new ArrayList<>();
                    for(int i = 0; i < numberOfBooks; i++){
                        System.out.println("Insert the id of the " + (i+1) + " book");
                        booksIds.add(terminalScan.next());
                    }
                    System.out.println("Return OK. The client penalty is " + library.returnBooks(clientReturnId, booksIds));
                    break;
                case SHOW_RENTED_BOOKS:
                    System.out.println(library.showRentedBooks());
                    break;
                case SHOW_TOP10_CLIENTS:
                    System.out.println(library.topTenCostumers());
                    break;
                case SHOW_LATE_CLIENTS:
                    System.out.println(library.showAllLateClients());
                        break;
                case SHOW_OPTIONS:
                    showOptions();
                    break;
                default:

            }
        }
        fm.writeLibrary(fileName, library);


    }

    public static void showOptions(){
        System.out.println(END_APPLICATION + " - End Application");
        System.out.println(REGISTER_BOOK + " - Register book");
        System.out.println(SHOW_ALL_BOOKS + " - List all registered books");
        System.out.println(SEARCH_BOOK_BY_TITLE + " - Search books by name");
        System.out.println(SEARCH_BOOK_BY_AUTHOR + " - Search books by author");
        System.out.println(REMOVE_BOOK_BY_ID + " - Remove book by id");
        System.out.println(RENT_A_BOOK + " - Rent a book for a client");
        System.out.println(RENEW_BOOK + " - Renew a book for a client");
        System.out.println(RETURN_BOOKS + " - Return a book");
        System.out.println(SHOW_RENTED_BOOKS + " - Show rented books");
        System.out.println(SHOW_TOP10_CLIENTS + " - Show top 10 clients");
        System.out.println(SHOW_LATE_CLIENTS + " - Show late clients");
        System.out.println(SHOW_OPTIONS + " - Show options");
    }
}
