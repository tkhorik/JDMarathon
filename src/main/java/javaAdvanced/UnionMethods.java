package javaAdvanced;

import java.util.HashSet;
import java.util.Set;

public class UnionMethods {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(10);
        set1.add(2);
        set1.add(11);


        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(10);
        set2.add(2);
        set2.add(13);
//union - объединение множеств
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);
//intersection - пересечение множеств
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);
//difference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);
    }
}
