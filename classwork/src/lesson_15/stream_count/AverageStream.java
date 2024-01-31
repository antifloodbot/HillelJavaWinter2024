package lesson_15.stream_count;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AverageStream {
    public static void main(String[] args) {
        System.out.println(IntStream.range(20, 100)
                .average()
                .getAsDouble());

        System.out.println(Stream.of(1,4,5,6).mapToDouble(e -> e).average().getAsDouble());
        System.out.println(Stream.of(1,4,5,6).mapToLong(e -> e).sum());
    }
}
