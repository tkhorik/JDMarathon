package javaAdvanced.comparatorInvestigations;

import java.util.*;

public class ConparableInterface {
    public static void main(String[] args) {
        List<MyPerson> peeopleList = new ArrayList<>();
        Set<MyPerson> peopleSet = new TreeSet<>();

        addElements(peeopleList);
        addElements(peopleSet);

        Collections.sort(peeopleList);

        System.out.println(peeopleList);
        System.out.println(peopleSet);
    }

    private static void addElements(Collection collection) {
        collection.add(new MyPerson(5, "Bobbbbb"));
        collection.add(new MyPerson(1, "Bob"));
        collection.add(new MyPerson(3, "Bobbb"));
    }
}

class MyPerson implements Comparable<MyPerson> {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "MyPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public MyPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPerson myPerson = (MyPerson) o;
        return id == myPerson.id &&
                Objects.equals(name, myPerson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(MyPerson myPerson) {

        if (this.id > myPerson.getId()) {
            return 1;
        } else if (this.id < myPerson.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
