package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDbMethodsRealization implements IDAOContact {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";


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

        Connection connection = getDBConnection();
        Statement stmt = null;
        ArrayList<Contact> contactList = new ArrayList<Contact>();

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
                       stmt.execute("CREATE TABLE IF NOT EXISTS PERSON(id int primary key, " +
                               "contactNumber varchar(255)" +
                               ", name varchar(255), " +
                               "surname varchar(255), " +
                               "phoneNumber varchar(255))");
/*                stmt.execute("INSERT INTO PERSON( name) VALUES( 'Anju')");
                stmt.execute("INSERT INTO PERSON( name) VALUES( 'Sonia')");
                stmt.execute("INSERT INTO PERSON( name) VALUES( 'Asha')");*/
            ResultSet rs = stmt.executeQuery("select * from PERSON");
            System.out.println("H2 Database inserted through Statement");
            while (rs.next()) {
                Contact contact = new Contact(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                contactList.add(contact);
//                stmt.close();
//                connection.commit();
//                    System.out.println("Id "+rs.getInt("id")+" Name "+rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        Log.info(String.valueOf(contactList));
        return contactList;
    }

    @Override
    public void delete(Contact t) {

    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
