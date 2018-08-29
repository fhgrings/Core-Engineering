package com.github.erguerra.core_eng.tema_4_agenda.app;
import com.github.erguerra.core_eng.tema_4_agenda.services.ContactList;

import java.util.Scanner;

public class Main {

    final static int END_APPLICATION = 0;
    final static int ADD_CONTACT = 1;
    final static int REMOVE_CONTACT_BY_ID = 2;
    final static int REMOVE_CONTACT_BY_NAME = 3;
    final static int SEARCH_CONTACT_BY_ID = 4;
    final static int SEARCH_CONTACT_BY_NAME = 5;
    final static int SHOW_ALL_CONTACTS_INFOS = 6;
    final static int SHOW_OPTIONS = 7;

    public static void main(String[] args) {
        int menuOperation = 1;
        ContactList contactList = new ContactList();
        Scanner terminalScan = new Scanner(System.in);

        showOptions();

        while(menuOperation != END_APPLICATION){

            menuOperation = terminalScan.nextInt();
            terminalScan.nextLine();

            switch(menuOperation){
                case ADD_CONTACT:
                    System.out.println("Insert the name of the new contact");
                    String name = terminalScan.next();
                    System.out.println("Insert the phone number of the new contact");
                    String phoneNumber = terminalScan.next();
                    System.out.println("Insert the email of the new contact");
                    String email = terminalScan.next();

                    if(contactList.addContact(name, phoneNumber, email))
                        System.out.println("Contact added successfully");
                    else{
                        System.out.println("Contacted was not added");
                    }
                    break;
                case REMOVE_CONTACT_BY_ID:
                    System.out.println("Insert the ID of the contact");
                        if(contactList.removeContactById(terminalScan.nextInt()))
                            System.out.println("Contact removed successfully");
                        else
                            System.out.println("Contact does not exist");
                    break;

                case REMOVE_CONTACT_BY_NAME:
                    System.out.println("Insert the name of the contact");
                    if(contactList.removeContactByName(terminalScan.nextLine()))
                        System.out.println("Contact removed successfully");
                    else
                        System.out.println("Contact does not exist");
                    break;

                case SEARCH_CONTACT_BY_ID:
                    System.out.println("Insert the ID of the contact");
                        System.out.printf(contactList.showContactInfo(contactList.searchContactById(terminalScan.nextInt())));
                    break;
                case SEARCH_CONTACT_BY_NAME:
                    System.out.println("Insert the name of the contact");
                    System.out.printf(contactList.showContactInfo(contactList.searchContactByName(terminalScan.nextLine())));
                    break;
                case SHOW_ALL_CONTACTS_INFOS:
                    System.out.printf(contactList.showAllContactsInfos());
                    break;
                case SHOW_OPTIONS:
                    showOptions();
                    break;
                default:

            }

        }
    }

    public static void showOptions(){
        System.out.println(END_APPLICATION + " - End Application");
        System.out.println(ADD_CONTACT + " - Add a new contact to the list");
        System.out.println(REMOVE_CONTACT_BY_ID + " - Remove contact by ID");
        System.out.println(REMOVE_CONTACT_BY_NAME + " - Remove contact by Name");
        System.out.println(SEARCH_CONTACT_BY_ID + " - Search contact by ID");
        System.out.println(SEARCH_CONTACT_BY_NAME + " - Search contact by Name");
        System.out.println(SHOW_ALL_CONTACTS_INFOS + " - Show all contacts information");
        System.out.println(SHOW_OPTIONS + " - Show options");
    }
}
