package com.github.walterolivos.core_eng.tema_5;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choices = 0;
        int id = 1;

        Data contactData = new Data();

        Scanner ler = new Scanner(System.in);

        while (choices != 6){
            System.out.println("Menu\n" +
                    "1 - Add contact\n" +
                    "2 - Remove contact\n" +
                    "3 - Search by name\n" +
                    "4 - Search by id\n" +
                    "5 - List contacts\n" +
                    "6 - Exit");
            choices = ler.nextInt();
            if (choices == 6){
                break;
            }

            switch (choices){
                case 1:
                    System.out.println("Enter contact name: ");
                    String name = ler.next();
                    Contact contact = new Contact(name, id);
                    contactData.addContact(contact);
                    id++;
                    break;

                case 2:
                    System.out.println("Enter contact name to be removed: ");
                    name = ler.next();
                    contactData.removeContact(name);
                    break;

                case 3:
                    System.out.println("Enter contact name: ");
                    name = ler.next();
                    System.out.println("ID: " + contactData.searchByName(name));
                    break;

                case 4:
                    System.out.println("Enter contact id: ");
                    id = ler.nextInt();
                    System.out.println("Name: " +  contactData.searchById(id));
                    break;

                case 5:
                    System.out.println(contactData.listContacts());
                    break;
            }
        }
        ler.close();
    }
}
