package javaAdvanced.mycontsctsbook.dao;

import javaAdvanced.mycontsctsbook.model.Contact;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDbMethodsRealization implements IDAOContact {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

/*
    public static void main(String[] args) throws Exception {
        try {
            // delete the database named 'test' in the user home directory for initialization
            DeleteDbFiles.execute("~", "test", true);
            batchInsertWithStatement();
            batchInsertWithPreparedStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

    public void addContact(Contact contact) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String Query = "INSERT INTO PERSON(CONTACTNUMBER, NAME, SURNAME, PHONENUMBER) values(?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(Query);

            preparedStatement.setString(1, contact.getContactNumber());
            preparedStatement.setString(2, contact.getName());
            preparedStatement.setString(3, contact.getSurname());
            preparedStatement.setString(4, contact.getPhoneNumber());
            preparedStatement.addBatch();

            int[] countWithoutException = preparedStatement.executeBatch();
            System.out.println("OK: countWithoutException = " + countWithoutException.length);
            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
            jdbcConnectionPool.dispose();
        }
    }

    private static void batchInsertWithStatement() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE PERSON(id int primary key, name varchar(255))");
            stmt.addBatch("INSERT INTO PERSON(id, name) VALUES(1, 'A')");
            stmt.addBatch("INSERT INTO PERSON(id, name) VALUES(2, 'B')");
            stmt.addBatch("INSERT INTO PERSON(id, name) VALUES(3, 'C')");

            int[] countWithoutException = stmt.executeBatch();
            System.out.println("OK: countWithoutException = " + countWithoutException.length);

            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
            jdbcConnectionPool.dispose();
        }
    }

    // Create H2 JdbcConnectionPool
    private static JdbcConnectionPool getConnectionPool() {
        JdbcConnectionPool cp = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        cp = JdbcConnectionPool.create(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return cp;
    }


    @Override
    public ArrayList<Contact> getAllStoredContacts() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        Statement stmt = null;
//        String Query = "INSERT INTO PERSON(CONTACTNUMBER, NAME, SURNAME, PHONENUMBER) values(?,?,?,?)";
        try {

            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from PERSON");
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
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            jdbcConnectionPool.dispose();
        }
        return contactList;
    }

    @Override
    public List<Contact> saveAll(List<Contact> in) {
        return null;
    }

    @Override
    public void delete(Contact t) {
    }
}
