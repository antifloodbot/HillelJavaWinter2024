package lesson_15.stream_count;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ForEachStream {
    public static void main(String[] args) {
        Stream.of(1,3,4,2,9,5,6,1,51,3,4,2,9,5,6,1,53,4,2,9,5,6,1,51,3,4)
                .parallel()
                .sequential()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("\n--------------------------");

        Stream.of(1,3,4,2,9,5,6,1,51,3,4,2,9,5,6,1,53,4,2,9,5,6,1,51,3,4)
                .parallel()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("\n--------------------------");

        List<Integer> collect = Stream.of(1, 3, 4, 2, 9, 5, 6, 1, 51, 3, 4, 2, 9, 5, 6, 1, 53, 4, 2, 9, 5, 6, 1, 51, 3, 4, 2, 9, 5, 6, 1, 5)
                .parallel().toList();

        collect.forEach(e -> System.out.print(e + " "));
        System.out.println("\n--------------------------");

        Set<Integer> collect1 = Stream.of(1, 3, 4, 2, 9, 5, 6, 1, 51, 3, 4, 2, 9, 5, 6, 1, 53, 4, 2, 9, 5, 6, 1, 51, 3, 4, 2, 9, 5, 6, 1, 5)
                .collect(Collectors.toSet());
        collect1.forEach(e -> System.out.print(e + " "));
        System.out.println("\n--------------------------");

        String str = Stream.of(1, 3, 4, 2, 9, 5, 6, 1, 51, 3, 4, 2, 9, 5, 6, 1, 53, 4, 2, 9, 5, 6, 1, 51, 3, 4, 2, 9, 5, 6, 1, 5)
                .map(String::valueOf).collect(Collectors.joining("-",  "<", ">"));
        System.out.println();
        System.out.println(str);
    }
}
