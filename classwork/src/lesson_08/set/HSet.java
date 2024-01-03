package lesson_08.set;

import java.util.HashSet;
import java.util.Set;

public class HSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(5);

        System.out.println(set.add("1"));
        System.out.println(set.add("1")); // false
        System.out.println(set.add("2"));
        System.out.println(set.add("3"));
        System.out.println(set.add("4"));
        System.out.println(set.add("55"));
        System.out.println(set.add("6"));

        System.out.println("---------------");

        System.out.println(set);

        int i = 3;
        int count = 0;
        String value = null;
        for (String s : set) {
            if (count++ == i)
                value = s;
        }
        System.out.println(value);
    }
}
