package javaAdvanced;

import java.util.*;

public class HashCodeAndEquils {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        //009 Методы hashcode и equals закончил в начале
        //010 реализация контракта для реализации правильной праверки

        Person person1 = new Person(1, "One");
        Person person2 = new Person(1, "One");

        map.put(person1, "One");
        map.put(person2, "One");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);


    }

    static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
