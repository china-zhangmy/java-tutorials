package org.twinsdaddy.javatutorials.exercises.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set);

        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add(null);
        System.out.println(list);

        list.stream()
                .filter(e -> e != null && e.length() >= 1)
                .forEach(b -> System.out.println(b));

        String joined = list.stream()
                .filter(e -> e != null && e.length() >= 1)
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println(joined);

        Object[] objs = list.toArray();
        System.out.println(objs.toString());

        String[] strs = list.toArray(new String[0]);
        System.out.println(strs.toString());
    }
}
