package lesson_08.task;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter digit to check: ");
        int number = scanner.nextInt();

        if (isArmstrongNumber(number)) {
            System.out.println(number + " is Armstrong number.");
        } else {
            System.out.println(number + " is not Armstrong number.");
        }

        scanner.close();
    }

    private static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }
}

