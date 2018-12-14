package javaAdvanced.comparatorInvestigations;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassForTest1 {
    public static void main(String[] args) {
        List<Integer> intArraylist = new ArrayList<>();
        intArraylist.add(1);
        intArraylist.add(123);
        intArraylist.add(12);
        intArraylist.add(1234);
        Collections.sort(intArraylist);
        System.out.println(intArraylist);
        Collections.sort(intArraylist, new IntegerReversComporator());
        System.out.println(intArraylist);
        Collections.sort(intArraylist, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer s, Integer t1) {
                        if (s < t1) {
                            return 1;
                        } else if (s > t1) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
        );
        System.out.println(intArraylist);


        List<String> literals = new ArrayList<>();
        literals.add("Bob");
        literals.add("Tory");
        literals.add("Merelin");
        literals.add("John");
        Collections.sort(literals);
        System.out.println(literals);
        Collections.sort(literals, new

                StringComparator());
        System.out.println(literals);
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        if (s.length() > t1.length()) {
            return 1;
        } else if (s.length() < t1.length()) {
            return -1;
        } else {
            return 0;
        }


    }
}

class IntegerReversComporator implements Comparator<Integer> {

    @Override
    public int compare(Integer s, Integer t1) {
        if (s < t1) {
            return 1;
        } else if (s > t1) {
            return -1;
        } else {
            return 0;
        }
    }
}
