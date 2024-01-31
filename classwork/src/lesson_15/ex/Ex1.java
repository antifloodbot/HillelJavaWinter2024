package lesson_15.ex;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        Integer i = 10;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(i *= 2);
        list.add(i);
        list.removeIf(j -> j == 10);
        System.out.println(list);
    }
}
