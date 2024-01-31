package lesson_15.stream_count;

import java.util.stream.Stream;

public class Count {
    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .filter(e -> e >= 2)
                        .count()
        );
    }
}
