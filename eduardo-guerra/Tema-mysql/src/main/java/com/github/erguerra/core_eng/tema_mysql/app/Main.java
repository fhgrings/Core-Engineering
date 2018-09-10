package com.github.erguerra.core_eng.tema_mysql.app;


import com.github.erguerra.core_eng.tema_mysql.models.ContactList;

import java.util.Scanner;

public class Main {

    private final static int END_APPLICATION = 0;
    private final static int ADD_CONTACT = 1;
    private final static int REMOVE_CONTACT_BY_ID = 2;
    private final static int SEARCH_CONTACT_BY_ID = 3;
    private final static int SEARCH_CONTACT_BY_NAME = 4;
    private final static int SHOW_ALL_CONTACTS_INFOS_ORDERED_BY_ID = 5;
    private final static int SHOW_ALL_CONTACTS_INFOS_ORDERED_BY_NAME = 6;
    private final static int SHOW_OPTIONS = 7;

    public static void main(String[] args) {
        int menuOperation = 1;
        ContactList contactList = new ContactList();
        Scanner terminalScan = new Scanner(System.in);

        showOptions();

        while (menuOperation != END_APPLICATION) {

            menuOperation = terminalScan.nextInt();
            terminalScan.nextLine();

            switch (menuOperation) {
                case ADD_CONTACT:
                    System.out.println("Insert the name of the new contact");
                    String name = terminalScan.nextLine();
                    System.out.println("Insert the phone number of the new contact");
                    String phoneNumber = terminalScan.nextLine();
                    System.out.println("Insert the email of the new contact");
                    String email = terminalScan.nextLine();
                    System.out.printf(contactList.addContact(name, phoneNumber, email));
                    break;

                case REMOVE_CONTACT_BY_ID:
                    System.out.println("Insert the ID of the contact");
                    int idToRemove = terminalScan.nextInt();
                    System.out.printf(contactList.removeContactById(idToRemove));
                    break;

                case SEARCH_CONTACT_BY_ID:
                    System.out.println("Insert the ID of the contact");
                    int idToSearch = terminalScan.nextInt();
                    System.out.printf(contactList.searchContactById(idToSearch));
                    break;

                case SEARCH_CONTACT_BY_NAME:
                    System.out.println("Insert the name of the contact");
                    String nameToSearch = terminalScan.nextLine();
                    System.out.printf(contactList.searchContactByName(nameToSearch));
                    break;

                case SHOW_ALL_CONTACTS_INFOS_ORDERED_BY_ID:
                    System.out.printf(contactList.listAllContactsOrderedById());
                    break;

                case SHOW_ALL_CONTACTS_INFOS_ORDERED_BY_NAME:
                    System.out.printf(contactList.listAllContactsOrderedByName());
                    break;

                case SHOW_OPTIONS:
                    showOptions();
                    break;
            }

        }
    }

    public static void showOptions() {
        System.out.println(END_APPLICATION + " - End Application");
        System.out.println(ADD_CONTACT + " - Add a new contact to the list");
        System.out.println(REMOVE_CONTACT_BY_ID + " - Remove contact by ID");
        System.out.println(SEARCH_CONTACT_BY_ID + " - Search contact by ID");
        System.out.println(SEARCH_CONTACT_BY_NAME + " - Search contact by Name");
        System.out.println(SHOW_ALL_CONTACTS_INFOS_ORDERED_BY_ID + " - Show all contacts ordered by id");
        System.out.println(SHOW_ALL_CONTACTS_INFOS_ORDERED_BY_NAME + " - Show all contacts ordered by name");
        System.out.println(SHOW_OPTIONS + " - Show options");
    }
}
