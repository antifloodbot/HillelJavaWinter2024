package lesson_19.io;

import java.util.Scanner;

public class ScannerInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input value: ...");

        if (sc.hasNextBigInteger()) {
            System.out.println(sc.nextInt());
        } else {
            System.out.println("not a digit");
        }
    }
}
