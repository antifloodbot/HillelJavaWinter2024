package lesson_14.streams;

import java.util.List;

public class DistinctStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 9, 2, 5, 6, 7, 2, 2, 1);

        ints.stream()
                .distinct()
                .forEach(i -> System.out.print(i + " "));
    }
}
