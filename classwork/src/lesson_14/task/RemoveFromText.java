package lesson_14.task;

import java.util.Arrays;

public class RemoveFromText {
    private final static String TEXT = "Скажите зачем эта маленькая княгиня сказал знязь Василий " +
            "зтихо Анне Павловне почему он особенно умного Мы зосле поговорим сказала Анна Павловна" +
            " улыбаясь";

    public static void main(String[] args) {
        String l = "с";
        Arrays.stream(TEXT.split(" "))
                .map(String::toLowerCase)
                .filter(w -> !w.startsWith(l) && w.length() != 6)
                .forEach(System.out::println);
    }

}
