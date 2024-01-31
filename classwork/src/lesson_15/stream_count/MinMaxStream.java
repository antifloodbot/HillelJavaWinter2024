package lesson_15.stream_count;

import java.util.stream.Stream;

public class MinMaxStream {
    public static void main(String[] args) {
        Integer min = Stream.of(1,32,5,61,21,4,2)
                .min(Integer::compareTo).get();
        System.out.println(min);

        Integer max = Stream.of(1,2,3,4,4,2,1)
                .max(Integer::compareTo).get();
        System.out.println(max);

    }
}
