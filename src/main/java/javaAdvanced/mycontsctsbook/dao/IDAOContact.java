package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDAOContact {

    List<Contact> saveAll(List<Contact> in);

    void addContact(Contact t);

    ArrayList<Contact> getAllStoredContacts() throws SQLException;

    void delete(Contact t);

}
