package javaAdvanced.mycontsctsbook.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MyContactBook {


    private static String getValuesFromScanner(String parameter) {
        System.out.println("\nВведите число! " + parameter);
        Scanner scanner = new Scanner(System.in);
        try {
            String i = scanner.nextLine();
            return i;

        } catch (NumberFormatException nfe) {
        }
        return parameter;
    }

    public static void addContactFromConsole(List<Contact> contactList) {

    }



    public static void printAllContactList(List<Contact> contactList) {
        for (Contact str : contactList) {
            System.out.println(str);
        }
    }

/*    public static void printAllContacIntoFile(List<Contact> contactList) {
        for (Contact str : contactList) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("the-file-name.txt", "UTF-8");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            assert writer != null;
            writer.println(contactList);
            writer.close();
        }
    }*/


    public static void addContact(Collection collection) {
        collection.add(new Contact(11, "1", "TestName", "TestSurname", "+123456789"));
        /*collection.add(new Contact(
                getValuesFromScanner("id"),
                getValuesFromScanner("contactNumber"),
                getValuesFromScanner("name"),
                getValuesFromScanner("surname"),
                getValuesFromScanner("phoneNumber")));*/
    }
}

