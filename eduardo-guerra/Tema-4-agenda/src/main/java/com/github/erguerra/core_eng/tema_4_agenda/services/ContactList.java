package com.github.erguerra.core_eng.tema_4_agenda.services;

import com.github.erguerra.core_eng.tema_4_agenda.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> contactList = new ArrayList<>();
    private static int nextId = 0;
    public static final int INVALID_ID = -1;
    public static final int INVALID_NAME = -1;

    public boolean addContact(String name, String phoneNumber, String email){
        Contact contact = new Contact(nextId, name, phoneNumber, email);
        nextId++;
        if(contactList.add(contact)){
            return true;
        }
        return false;
    }

    public String showAllContactsInfos(){
        if(contactList.isEmpty())
            return "No contact registered";
        String allContactInfo = "";
        for(int i = 0; i<contactList.size(); i++){
            allContactInfo = allContactInfo.concat(contactList.get(i).showContactInformation());
        }
        return allContactInfo;
    }

    public int searchContactByName(String name){
        for(int i = 0; i<contactList.size(); i++){
            if(contactList.get(i).getName().equals(name)){
                return i;
            }
        }
        return INVALID_NAME;
    }

    public int searchContactById(int id){
        for(int i = 0; i<contactList.size(); i++){
            if(contactList.get(i).getId() == id){
                return i;
            }
        }
        return INVALID_ID;
    }


    public boolean removeContactById(int id){
        if(contactList.isEmpty())
            return false;
        int index = searchContactById(id);
        if(index != INVALID_ID){
            contactList.remove(getContactByIndex(index));
            return true;
        }else
            return false;
    }

    public boolean removeContactByName(String name){
        if(contactList.isEmpty())
            return false;
        int index = searchContactByName(name);
        if(index != INVALID_NAME){
            contactList.remove(getContactByIndex(index));
            return true;
        }else
            return false;
    }

    public String showContactInfo(int index){
        if(index >= 0 && index < contactList.size())
            return contactList.get(index).showContactInformation();

        return "Invalid index\n";
    }

    public void cleanNextID(){
        this.nextId = 0;
    }

    private Contact getContactByIndex(int index){
        return contactList.get(index);
    }



}
