package lesson_08.list;

import java.util.LinkedList;

public class ALandLL {
    public static void main(String[] args) {
        LinkedList<String> linked = new LinkedList<>();

        linked.add("1");
        linked.add("2");
        linked.add("3");
        linked.add("4");
        linked.add("5");

        System.out.println(linked.getFirst());
        System.out.println(linked.getLast());
        System.out.println(linked.get(2));


    }
}
