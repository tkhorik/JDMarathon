package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public interface IDAOContact {

    List<Contact> saveAll(List<Contact> in);

    Contact addContact(Contact t);

    ArrayList<String> getAllStoredContacts(List<Contact> contactList);

    void delete(Contact t);

}
