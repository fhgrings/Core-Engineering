package com.github.erguerra.core_eng.tema_4_agenda.tests;

import com.github.erguerra.core_eng.tema_4_agenda.services.ContactList;
import org.junit.Assert;
import org.junit.Test;

public class ContactListTests {

    @Test
    public void addContact(){

        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        Assert.assertEquals(true, contactList.addContact("Eduardo", "3262-1130", "eduardo.guerra@ilegra.com"));
    }
    @Test
    public void removeContactEmpty(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        Assert.assertEquals(false, contactList.removeContactById(3));

    }
    @Test
    public void searchContactByID(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        contactList.addContact("Eduardo", "3262-1130", "eduardo.guerra@ilegra.com");
        Assert.assertEquals(0, contactList.searchContactById(0));
    }
    @Test
    public void searchContactByName(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        contactList.addContact("Eduardo", "3262-1130", "eduardo.guerra@ilegra.com");
        Assert.assertEquals(0, contactList.searchContactByName("Eduardo"));
    }
    @Test
    public void removeContactByID(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        contactList.addContact("Walter", "981633885", "walter.oliveira@ilegra.com");
        contactList.addContact("Eduardo", "3262-1130", "eduardo.guerra@ilegra.com");
        contactList.removeContactById(0);
        Assert.assertEquals("1 Eduardo 3262-1130 eduardo.guerra@ilegra.com\n",contactList.showAllContactsInfos());
    }
    @Test
    public void removeContactByName(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        contactList.addContact("Walter", "981633885", "walter.oliveira@ilegra.com");
        contactList.addContact("Eduardo", "3262-1130", "eduardo.guerra@ilegra.com");
        contactList.removeContactByName("Eduardo");
        Assert.assertEquals("0 Walter 981633885 walter.oliveira@ilegra.com\n", contactList.showAllContactsInfos());
    }
    @Test
    public void showAllContactsInfoEmpty(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        Assert.assertEquals("No contact registered", contactList.showAllContactsInfos());
    }
    @Test
    public void showAllContactsInfo(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        contactList.addContact("Eduardo", "3262-1130", "eduardo.guerra@ilegra.com");
        contactList.addContact("Walter", "981633885", "walter.oliveira@ilegra.com");
        Assert.assertEquals("0 Eduardo 3262-1130 eduardo.guerra@ilegra.com\n1 Walter 981633885 walter.oliveira@ilegra.com\n", contactList.showAllContactsInfos());
    }
    @Test
    public void showContactInfo(){
        ContactList contactList = new ContactList();
        contactList.cleanNextID();
        Assert.assertEquals("Invalid index\n", contactList.showContactInfo(99999));
    }





}
