package javaAdvanced.comparatorInvestigations;

import java.util.*;

public class InvestigationsInterfaceComparator {
    public static void main(String[] args) {
        List<AnotherINterfacedPerson> personList = new ArrayList<>();
        Set<AnotherINterfacedPerson> personTreeset = new TreeSet<>();

        addPeople(personList);
        addPeople(personTreeset);

        Collections.sort(personList);
//        Collections.sort(personTreeset);

        System.out.println(personList);
        System.out.println(personTreeset);
    }

    private static void addPeople(Collection collection) {
        collection.add(new AnotherINterfacedPerson(33, "Anjelika"));
        collection.add(new AnotherINterfacedPerson(1, "John"));
        collection.add(new AnotherINterfacedPerson(22, "Simbean"));
    }
}

class AnotherINterfacedPerson implements Comparable<AnotherINterfacedPerson> {
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AnotherINterfacedPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherINterfacedPerson that = (AnotherINterfacedPerson) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AnotherINterfacedPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(AnotherINterfacedPerson o) {
        if (this.name.length() > o.getName().length()) {
            return 1;
        } else if (this.name.length() < o.getName().length()) {
            return -1;
        } else {
            return 0;
        }
    }
}