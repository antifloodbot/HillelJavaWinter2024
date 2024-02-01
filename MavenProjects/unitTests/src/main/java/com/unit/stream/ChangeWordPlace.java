package com.unit.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeWordPlace {
    public String changeWordOrder(String text) {
        return Arrays.stream(text.split("\\. "))
                .map(s -> {
                    return swap(s);
                }).collect(Collectors.joining(". "));
    }

    private String swap(String s) {
        String[] str = s.split(" ");
        String tmp = str[0];
        str[0] = str[str.length - 1];
        str[str.length - 1] = tmp;
        return String.join(" ", str);
    }
}


