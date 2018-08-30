package com.github.walterolivos.core_eng.tema_5;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContactListTest {

    private Data contactData = new Data();

    @Test
    public void addContactTest(){
        Contact contactTest = new Contact("ContactTest", 1);
        contactData.addContact(contactTest);
        assertEquals(1, contactData.listContacts());
    }

    @Test
    public void removeContactTest(){
        contactData.removeContact("ContactTest");
        assertEquals(0, contactData.listContacts());
    }

    @Test
    public void searchByNameTest(){
        Contact contactTest = new Contact("ContactTest", 1);
        contactData.addContact(contactTest);

        assertEquals(1, contactData.searchByName("ContactTest"));
    }

    @Test
    public void searchByIdTest(){
        Contact contactTest = new Contact("ContactTest", 1);
        contactData.addContact(contactTest);

        assertEquals("ContactTest",contactData.searchById(1));
    }

    @Test
    public void listContactsTest(){
        Contact contactTest = new Contact("ContactTest", 1);
        contactData.addContact(contactTest);

        assertEquals("Contact: ContactTest ID: 1\n", contactData.listContacts());
    }
}
