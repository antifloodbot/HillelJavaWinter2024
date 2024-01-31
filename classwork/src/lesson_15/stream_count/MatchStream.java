package lesson_15.stream_count;

import java.util.stream.Stream;

public class MatchStream {
    public static void main(String[] args) {
        Boolean allMatchTrue = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 9)
                .allMatch(e -> e < 10);
        System.out.println(allMatchTrue);

        Boolean allMatchFalse = Stream.of(1, 2, 3, 4, 5, 6)
                .allMatch(e -> e < 6);
        System.out.println(allMatchFalse);

        Boolean anyMatchTrue = Stream.of(1, 2, 3, 4, 5)
                .anyMatch(e -> e == 1);
        System.out.println(anyMatchTrue);

        Boolean noneMatchTrue = Stream.of(1, 2, 3, 4, 5, 22)
                .noneMatch(e -> e > 200);
        System.out.println(noneMatchTrue);
    }
}
