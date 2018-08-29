package com.github.erguerra.core_eng.tema_4_agenda.tests;

import com.github.erguerra.core_eng.tema_4_agenda.models.Contact;
import org.junit.Assert;
import org.junit.Test;

public class ContactTests {

    Contact contact = new Contact(5, "Eduardo", "3262-1130", "eduardo.guerra@ilegra.com");

    @Test
    public void showContactInformation(){
        Assert.assertEquals("5 Eduardo 3262-1130 eduardo.guerra@ilegra.com\n", contact.showContactInformation());
    }
    @Test
    public void getID(){
        Assert.assertEquals(5, contact.getId());

    }
    @Test
    public void getName(){
        Assert.assertEquals("Eduardo", contact.getName());

    }



}
