package lesson_19.io;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner("Hello, World  , olala, 321");
        sc.useDelimiter(", ");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
