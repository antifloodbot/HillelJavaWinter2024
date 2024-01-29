package stringFilter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "Five");

        StringFilter stringFilter = new StringFilter();
        System.out.println(stringFilter.filterAndPrintLowerCase4Length(strings));

    }
}
