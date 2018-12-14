package javaAdvanced;

import java.util.*;

public class SetLession {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("More");
        hashSet.add("Max");
        hashSet.add("Mike");
        hashSet.add("Mishele");

        linkedHashSet.add("More");
        linkedHashSet.add("Max");
        linkedHashSet.add("Mike");
        linkedHashSet.add("Mishele");

        treeSet.add("More");
        treeSet.add("Dax");
        treeSet.add("Aike");
        treeSet.add("Mishele");

        for (String name : hashSet) {
            System.out.println(name);
        }
        System.out.println("-----------");

        for (String name : linkedHashSet) {
            System.out.println(name);
        }
        System.out.println("-----------");
        for (String name : treeSet) {
            System.out.println(name);
        }

        System.out.println(hashSet.contains("More"));
        System.out.println(hashSet.contains("MQWSAQ"));
        System.out.println(linkedHashSet.contains("More"));
        System.out.println(linkedHashSet.contains("MQWSAQ"));
        System.out.println(treeSet.contains("More"));
        System.out.println(treeSet.contains("MQWSAQ"));


        System.out.println(hashSet.isEmpty());
    }
}
