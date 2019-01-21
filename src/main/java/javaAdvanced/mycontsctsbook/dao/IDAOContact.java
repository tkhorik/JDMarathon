package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public interface IDAOContact {

    List<Contact> saveAll(List<Contact> in);

    Contact addContact(Contact t);

    ArrayList<Contact> getAllStoredContacts();

    void delete(Contact t);

}
