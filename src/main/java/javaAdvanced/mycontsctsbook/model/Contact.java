package javaAdvanced.mycontsctsbook.model;

import java.nio.charset.Charset;
import java.util.Objects;

public class Contact implements Comparable<Contact> {

    int id;
    String contactNumber;
    String name;
    String surname;
    String phoneNumber;

    public Contact(String contactNumber, String name, String surname, String phoneNumber) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactNumber=" + contactNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                contactNumber == contact.contactNumber &&
                Objects.equals(name, contact.name) &&
                Objects.equals(surname, contact.surname) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactNumber, name, surname, phoneNumber);
    }

    public Contact(int id, String contactNumber, String name, String surname, String phoneNumber) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Contact contact) {
        return 0;
    }
}