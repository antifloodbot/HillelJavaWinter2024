package com.unit.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeWordInText {
    //16.  В некотором предложении текста слова заданной длины заменить указанной подстрокой,
    //длина которой может не совпадать с длиной слова.
    static String TEXT = "test_word";
    static String TEXT_EXAMPLE = "test word 231 3465435 345345 234 1245 3456 12345243 q345234";

    public String changeText(String text, String word, Long length) {
        return Arrays.stream(text.split(" "))
                .map(s -> s.length() == length ? word : s)
                .collect(Collectors.joining(" "));
    }
}
