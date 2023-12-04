package lesson_02;

import java.util.Locale;

public class StringPool {
    public static void main(String[] args) {
        String str1 = "cat"; // stringPool
        String str2 = "cat"; // stringPool
        String str3 = new String("cat"); //heap

        str3 = str3.toLowerCase().intern();
        str3 = str3.intern();

        System.out.println(str1 == str2); //true - links
        System.out.println(str1.equals(str2)); //true - value
        System.out.println(str1 == str3); //false - links
        System.out.println(str1.equals(str3)); //true - value
    }
}
