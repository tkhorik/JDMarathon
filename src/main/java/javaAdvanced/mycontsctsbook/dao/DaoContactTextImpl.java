package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoContactTextImpl implements IDAOContact {
    @Override
    public List<Contact> saveAll(List<Contact> in) {

        for (Contact str : in) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("the-file-name.txt", "UTF-8");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            assert writer != null;
            writer.println(in);
            writer.close();
        }
        return in;
    }

    @Override
    public void addContact(Contact t) {

    }

    @Override
    public ArrayList<Contact> getAllStoredContacts() {
//        Scanner s = null;
//        try {
//            s = new Scanner(new File("/Users/marv/IdeaProjects/jdmarathon/the-file-name.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ArrayList<Contact> list = new ArrayList<Contact>();
//        while (s.hasNext()){
//            list.add(s.next());
//        }
////        System.out.println(list );
////        s.close();//todo: create split method to add all array elements in correct places
////        ArrayList<Contact> result = new ArrayList<>();
//        return list;
        return null;
    }

    @Override
    public void delete(Contact t) {

    }



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
}
