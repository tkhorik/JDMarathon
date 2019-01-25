package javaAdvanced.mycontsctsbook.app;

import javaAdvanced.mycontsctsbook.dao.IDAOContact;
import javaAdvanced.mycontsctsbook.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static javaAdvanced.mycontsctsbook.model.MyContactBook.*;

public class Runner {
    static ApplicationContext context;
    static IDAOContact idaoContact;
    static IDAOContact daotextfilesaving;

    public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("context.xml");
        IDAOContact myDbMethodsRealization = (IDAOContact) context.getBean("myDbMethodsRealization");

//        daotextfilesaving = (IDAOContact) context.getBean("mySavingIntoFileBean");
//        idaoContact = (IDAOContact) context.getBean("myPersonalBean");
        ArrayList<Contact> contactList = new ArrayList<>();



//        System.out.println(daotextfilesaving.getAllStoredContacts());

//        daotextfilesaving.addContact();
//        daotextfilesaving.saveAll();

//        addContactFromConsole(contactList);
//        addContact(contactList);
//        daotextfilesaving.saveAll(contactList);



        /*
        * надо дл] начала реализовать
        * daoDBimpl
        * 1
        *
        *
        * */

      contactList = myDbMethodsRealization.getAllStoredContacts();
        System.out.println("qwe= "+contactList);
        System.out.println(contactList);

//        printAllContactList(contactList);

//        получить данные пользователя
//        сохранить данные пользователя
//        прочитать данные пользователя которые сохранились

    }
}
