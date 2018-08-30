package com.github.walterolivos.core_eng.tema_5;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private String list;
    List<Contact> contactList = new ArrayList<>();


    public void addContact(Contact contact){
        contactList.add(contact);
        System.out.println("Contact added");
    }

    public String listContacts(){
        for (Contact contact : contactList){
            if (list == null) {
                System.out.println("List is empty");
            }else {
                list =  list.concat(contact.contactInfos());
            }
        }
        return list;
    }

    public int searchByName(String nome) {
        int id = 0;
        for (Contact contact : contactList) {
            if (contact.getName().contains(nome)) {
                id = contact.getId();
                return id;
            }
        }
        if (id == 0) {
            System.out.println("Not found");
        }
        return id;
    }

        public String searchById(int id){
        String name = null;
        for (Contact contact : contactList){
            if (contact.getId() == id){
                name = contact.getName();
                return name;
            }
            if (name == null){
                System.out.println("Not found");
                break;
            }
        }
        return name;
    }

    public void removeContact(String name){
        for (Contact contact : contactList){
            if (contact.getName().contains(name)){
                contactList.remove(contact);
                System.out.println("Contact " + name + " removed");
                break;
            }
        }
    }
}
