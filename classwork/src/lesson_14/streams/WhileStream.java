package lesson_14.streams;

import java.util.List;

public class WhileStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        ints.stream().takeWhile(i -> i % 5 > 0).forEach(i -> System.out.print(i + " "));
        System.out.println();
        ints.stream().dropWhile(i -> i % 5 > 0).forEach(i -> System.out.print(i + " "));
    }
}
