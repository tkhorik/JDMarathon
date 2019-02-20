package javaAdvanced.mycontsctsbook.app;

import javaAdvanced.mycontsctsbook.dao.IDAOContact;
import javaAdvanced.mycontsctsbook.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static javaAdvanced.mycontsctsbook.model.MyContactBook.*;

public class Runner {
    static ApplicationContext context;
    static IDAOContact idaoContact;
    static IDAOContact daotextfilesaving;

    public static void main(String[] args) throws SQLException {

        context = new ClassPathXmlApplicationContext("context.xml");
        IDAOContact myDbMethodsRealization = (IDAOContact) context.getBean("myDbMethodsRealization");
        ArrayList<Contact> allStoredContacts = myDbMethodsRealization.getAllStoredContacts();
        Contact contact = new Contact("contactumner", "name", "surname", "+12223123");
        myDbMethodsRealization.addContact(contact);
        printAllContactList(allStoredContacts);

//        получить данные пользователя
//        сохранить данные пользователя
//        прочитать данные пользователя которые сохранились

    }
}
