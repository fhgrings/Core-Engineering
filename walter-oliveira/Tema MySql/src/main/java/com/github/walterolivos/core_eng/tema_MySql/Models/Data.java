package com.github.walterolivos.core_eng.tema_MySql.Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.walterolivos.core_eng.tema_MySql.Services.ContactDAO;

public class Data {

    public String showContactInformation(Optional<Contact> contact) {
        if (contact.isPresent()) {
            return contact.get().getId() + " " + contact.get().getName() + "\n";
        } else {
            return "Contact does not exist\n";
        }
    }

    public String showListOfContactsInformation(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            return "No contact found\n";
        }
        String contactsInformation = "";
        for (Contact contact : contacts) {
            Optional<Contact> optionalContact = Optional.ofNullable(contact);
            contactsInformation += showContactInformation(optionalContact);
        }
        return contactsInformation;
    }

    public String listAllContactsOrderedById() {
        ContactDAO contactDAO = new ContactDAO();
        return showListOfContactsInformation(contactDAO.searchAllClientsById());
    }

    public String listAllContactsOrderedByName() {
        ContactDAO contactDAO = new ContactDAO();
        return showListOfContactsInformation(contactDAO.searchAllClientsByName());
    }

    public String addContact(String name){
        ContactDAO contactDAO = new ContactDAO();
        if (contactDAO.addContact(name)) {
            return "Contact added with success\n";
        } else
            return "Contact was not added\n";
    }

    public String listContacts(){
        ContactDAO contactDAO = new ContactDAO();
        return showListOfContactsInformation(contactDAO.showAllContacts());
    }

    public String searchByName(String nome) {
        ContactDAO contactDAO = new ContactDAO();
        List<Contact> contacts = contactDAO.searchContactByName(nome);
        return showListOfContactsInformation(contacts);
    }

    public String searchById(int id){
        ContactDAO contactDAO = new ContactDAO();
        Optional<Contact> contact = contactDAO.searchContactById(id);
        return showContactInformation(contact);
    }

    public String removeContact(int id){
        ContactDAO contactDAO = new ContactDAO();
        if (contactDAO.removeContactById(id)) {
            return "Contact was removed with success\n";
        } else {
            return "Contact was not removed\n";
        }
    }
}
