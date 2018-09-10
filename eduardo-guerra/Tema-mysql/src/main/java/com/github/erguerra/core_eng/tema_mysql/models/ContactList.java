package com.github.erguerra.core_eng.tema_mysql.models;

import com.github.erguerra.core_eng.tema_mysql.services.ContactDAO;

import java.util.List;
import java.util.Optional;

public class ContactList {

    public String showContactInformation(Optional<Contact> contact) {
        if (contact.isPresent()) {
            return contact.get().getId() + " " + contact.get().getName() + " " +
                    contact.get().getPhoneNumber() + " " + contact.get().getEmail() + "\n";
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

    public String searchContactById(int id) {
        ContactDAO contactDAO = new ContactDAO();
        Optional<Contact> contact = contactDAO.searchContactById(id);
        return showContactInformation(contact);
    }

    public String searchContactByName(String name) {
        ContactDAO contactDAO = new ContactDAO();
        List<Contact> contacts = contactDAO.searchContactByName(name);
        return showListOfContactsInformation(contacts);
    }

    public String listAllContacts() {
        ContactDAO contactDAO = new ContactDAO();
        return showListOfContactsInformation(contactDAO.showAllContacts());

    }

    public String listAllContactsOrderedById() {
        ContactDAO contactDAO = new ContactDAO();
        return showListOfContactsInformation(contactDAO.searchAllClientsOrderById());
    }

    public String listAllContactsOrderedByName() {
        ContactDAO contactDAO = new ContactDAO();
        return showListOfContactsInformation(contactDAO.searchAllClientsOrderByName());
    }

    public String addContact(String name, String phoneNumber, String email) {
        ContactDAO contactDAO = new ContactDAO();
        if (contactDAO.addContact(name, phoneNumber, email)) {
            return "Contact added with success\n" + listAllContacts();
        } else
            return "Contact was not added\n";
    }

    public String removeContactById(int id) {
        ContactDAO contactDAO = new ContactDAO();
        if (contactDAO.removeContactById(id)) {
            return "Contact was removed with success\n" + listAllContacts();
        } else {
            return "Contact was not removed\n";
        }
    }
}
