package lesson_15.stream_count;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinByStream {
    public static void main(String[] args) {
        Optional<String> collect = Stream.of("a", "bb", "ccc", "dddd", "ttttt")
                .min(Comparator.comparing(String::length));

        collect.ifPresent(System.out::println);

        collect = Stream.of("a", "bb", "ccc", "dddd", "ttttt")
                .max(Comparator.comparing(String::length));

        collect.ifPresent(e -> System.out.println(e));

        Map<Integer, List<String>> ls = Stream.of("a", "c", "bb", "aa", "ccc", "dddd", "ttttt")
                .collect(Collectors.groupingBy(String::length));

        ls.entrySet().forEach(System.out::println);
        System.out.println(ls.containsValue("c"));

        Map<Character, String> map = Stream.of(500, 510, 520, 530, 540)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(), //key
                        String::valueOf //value
                ));
        System.out.println(map);

    }
}
