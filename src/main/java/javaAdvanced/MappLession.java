package javaAdvanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MappLession {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> likedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        testMapClass(hashMap);
        testMapClass(likedHashMap);
        testMapClass(treeMap);
    }

    public static void testMapClass(Map<Integer, String> map) {
        map.put(39, "Mike");
        map.put(139, "Mike2");
        map.put(9, "Mike3");
        map.put(1, "Mike4");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
