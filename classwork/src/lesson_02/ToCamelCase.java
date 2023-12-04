package lesson_02;

import java.util.Locale;

public class ToCamelCase {
    public static void main(String[] args) {
        String result = args[0];
        for (int i = 1; i < args.length; i++) {
            result = result.concat(changeFirstLetterToUpperCase(args[i]));
        }
        System.out.println(result);
        System.out.println(result.charAt(result.length() - 1));
    }

    private static String changeFirstLetterToUpperCase(String str) {
        return str.replaceFirst(String.valueOf(str.charAt(0)), String.valueOf(str.charAt(0)).toUpperCase());
    }
}
