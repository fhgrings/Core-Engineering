package com.github.walterolivos.core_eng.tema_MySql.App;

import com.github.walterolivos.core_eng.tema_MySql.Models.Contact;
import com.github.walterolivos.core_eng.tema_MySql.Models.Data;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choices = 0;
        int id = 1;

        Data contactData = new Data();

        Scanner ler = new Scanner(System.in);

        while (choices != 7){
            System.out.println("Menu\n" +
                    "1 - Add contact\n" +
                    "2 - Remove contact\n" +
                    "3 - Search by name\n" +
                    "4 - Search by id\n" +
                    "5 - List contacts by name\n" +
                    "6 - List contacts by id\n" +
                    "7 - Exit");
            choices = ler.nextInt();
            if (choices == 7){
                break;
            }

            switch (choices){
                case 1:
                    System.out.println("Insert the name of the new contact");
                    String name = ler.next();
                    System.out.println(contactData.addContact(name));
                    break;

                case 2:
                    System.out.println("Insert the ID of the contact");
                    int idToRemove = ler.nextInt();
                    System.out.printf(contactData.removeContact(idToRemove));
                    break;

                case 3:
                    System.out.println("Insert the name of the contact");
                    String nameToSearch = ler.next();
                    System.out.printf(contactData.searchByName(nameToSearch));
                    break;

                case 4:
                    System.out.println("Insert the ID of the contact");
                    int idToSearch = ler.nextInt();
                    System.out.printf(contactData.searchById(idToSearch));
                    break;

                case 5:
                    System.out.println(contactData.listAllContactsOrderedByName());
                    break;

                case 6:
                    System.out.println(contactData.listAllContactsOrderedById());
                    break;
            }
        }
        ler.close();
    }
}
