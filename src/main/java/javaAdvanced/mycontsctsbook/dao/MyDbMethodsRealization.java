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
    public void addContact(Contact contact) {
        Connection cn = getDBConnection();
        Statement stmt = null;
        try {
            createDbIfNotExist(cn);
            cn.setAutoCommit(false);
                        stmt = createDbIfNotExist(cn);
//            stmt = cn.createStatement();
//            stmt.execute("CREATE TABLE IF NOT EXISTS PERSON(idt bigint auto_increment,contactNumber varchar(255),name varchar(255), surname varchar(255),phoneNumber varchar(255))");
            cn.commit();
            String sql = "INSERT INTO PERSON (CONTACTNUMBER, NAME, SURNAME, PHONENUMBER) " +
                    "VALUES('"+contact.getContactNumber() + "','" + contact.getName() + "','" + contact.getName() + "','" + contact.getPhoneNumber() + "')";
            stmt.execute(sql);
            cn.commit();
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    @Override
    public ArrayList<Contact> getAllStoredContacts() throws SQLException {

        Connection connection = getDBConnection();
        Statement stmt = null;
        stmt = connection.createStatement();

        ArrayList<Contact> contactList = new ArrayList<Contact>();

        try {
            connection.setAutoCommit(false);
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
        return contactList;
    }

     Statement createDbIfNotExist(Connection connection) throws SQLException {
        Statement stmt;
        stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS PERSON(id bigint auto_increment primary key, " +
                "contactNumber varchar(255)," +
                "name varchar(255), " +
                "surname varchar(255), " +
                "phoneNumber varchar(255))");
        return stmt;
    }


    @Override
    public void delete(Contact t) {
    }

    private Connection getDBConnection() {
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