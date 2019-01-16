package javaAdvanced.mycontsctsbook.app;

import javaAdvanced.mycontsctsbook.dao.IDAOContact;
import javaAdvanced.mycontsctsbook.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

import static javaAdvanced.mycontsctsbook.model.MyContactBook.*;

public class Runner {
    static ApplicationContext context;
    static IDAOContact idaoContact;
    static IDAOContact daotextfilesaving;

    public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("context.xml");
        daotextfilesaving = (IDAOContact) context.getBean("mySavingIntoFileBean");
//        idaoContact = (IDAOContact) context.getBean("myPersonalBean");

        List<Contact> contactList = new LinkedList<>();


//        idaoContact.saveAll(contactList);
        daotextfilesaving.getAllStoredContacts(contactList);
        System.out.println(contactList);

//        daotextfilesaving.addContact();
//        daotextfilesaving.saveAll();

        addContactFromConsole(contactList);
        addContact(contactList);
        daotextfilesaving.saveAll(contactList);
//        printAllContactList(contactList);

//        получить данные пользователя
//        сохранить данные пользователя
//        прочитать данные пользователя которые сохранились

    }
}
