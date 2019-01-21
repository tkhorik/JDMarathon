package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class DaoContactDBImpl implements IDAOContact {
    @Override
    public List<Contact> saveAll(List<Contact> in) {
        System.out.println("Im DB saving method implementation");
        return in;
    }

    @Override
    public Contact addContact(Contact t) {
        return null;
    }

    @Override
    public ArrayList<Contact> getAllStoredContacts() {
        return null;
    }

    @Override
    public void delete(Contact t) {

    }
}
