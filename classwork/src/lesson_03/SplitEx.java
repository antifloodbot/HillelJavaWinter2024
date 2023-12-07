package lesson_03;

import java.util.Arrays;

public class SplitEx {
    public static void main(String[] args) {
        String str =  "Hello worldhelolololololo ";

        String[] s = str.split("l ");
        System.out.println(Arrays.toString(s));
    }
}
