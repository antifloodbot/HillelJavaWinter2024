package lesson_08.set;

import java.util.Set;
import java.util.TreeSet;

public class TSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet();

        set.add(15);
        set.add(1);
        set.add(55);
        set.add(0);

        System.out.println(set);
        set.add(2);
        System.out.println(set);
        System.out.println("-------------");

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("one");
        treeSet.add("One");
        treeSet.add("Tne");

        System.out.println(treeSet);

        treeSet.add("Onee");
        System.out.println(treeSet);

    }
}
