package javaAdvanced.comparatorInvestigations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomObjectComporator {
    public static void main(String[] args) {
        List<Person> personlist = new ArrayList<>();
        personlist.add(new Person(2, "Mike"));
        personlist.add(new Person(1, "Jake"));
        personlist.add(new Person(3, "Jinn"));

        System.out.println(personlist);

        Collections.sort(personlist, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getId() > p2.getId()) {
                    return 1;
                } else if (p1.getId() < p2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(personlist);
    }
}

class Person {

    private int id;
    private String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
