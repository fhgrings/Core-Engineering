package com.github.erguerra.core_eng.tema_facade.app;

import com.github.erguerra.core_eng.tema_facade.api_connection.JSONPlaceHolderFacade;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        JSONPlaceHolderFacade todoInformation = new JSONPlaceHolderFacade();
        Scanner terminalScanner = new Scanner(System.in);
        System.out.println("Insert the id of the ToDo you wanna see");
        System.out.println(todoInformation.getTodoInformation(terminalScanner.nextInt()));
    }

}
