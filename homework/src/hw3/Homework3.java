package hw3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    public void forPrintFrom1to99() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }

    public void whilePrintFrom1to99() {
        int i = 1;
        while (i < 100) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
            i++;
        }
    }

    public void doWhilePrintFrom1to99() {
        int i = 1;
        do {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i < 100);
    }

    public void forCalculateFactorial(long l) {
        long factorial = 1;
        for (int i = 1; i <= l; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }

    public void whileCalculateFactorial(long l) {
        long factorial = 1;
        long i = 1;
        while (i <= l) {
            factorial *= i;
            i++;
        }
        System.out.println(factorial);
    }

    public void doWhileCalculateFactorial(long l) {
        long factorial = 1;
        long i = 1;
        do {
            factorial *= i;
            i++;
        } while (i <= l);
        System.out.println(factorial);
    }

    public void calculateExponentialExpression(long x, long n) {
        if (n == 0) {
            System.out.println("Result of " + x + " and " + n + " is: 1");
        } else if (n < 0) {
            System.out.println("Exponent must be a non-negative integer.");
        } else {
            long result = 1;
            for (long i = 1; i <= n; i++) {
                result *= x;
            }
            System.out.println("Result of " + x + " and " + n + " is: " + result);
        }
    }

    public void outputFirst10Numbers() {
        int current = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print(current + " ");
            current -= 5;
        }
    }

    public void multiplicationTable() {
        Scanner scanner = new Scanner(System.in);
        int inputValue = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("Please enter any digit");
                inputValue = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: You have entered not valid value, please enter valid digit");
                scanner.nextLine();
            }
        }
        System.out.println("Multiplication table for digit " + inputValue + " is:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(inputValue + " * " + i + " = " + (inputValue * i));
        }
    }

    public void oddNumbersArray() {
        int[] oddNumbers = new int[10];
        for (int i = 0; i < 10; i++) {
            oddNumbers[i] = 2 * i + 1;
        }
        for (int number : oddNumbers) {
            System.out.print(number + ",");
        }
    }

    public void smallestNumberOfTheArray() {
        Random random = new Random();
        int[] randomArray = new int[10];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100);
        }

        int min = randomArray[0];
        for (int j : randomArray) {
            if (j < min) {
                min = j;
            }
        }
        System.out.println("Minimal element of the array " + Arrays.toString(randomArray) + " is: " + min);
    }

    public void biggestNumberOfTheArray() {
        Random random = new Random();
        int[] randomArray = new int[10];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100);
        }

        int max = randomArray[0];
        for (int j : randomArray) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Maximal element of the array " + Arrays.toString(randomArray) + " is: " + max);
    }

    public void swapMaximalAndMinimalDigitInTheArray() {
        Random random = new Random();
        int[] randomArray = new int[10];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(101) - 50;
        }
        System.out.println("Random generated array is :\n" + Arrays.toString(randomArray));
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < randomArray.length; i++) {
            if (randomArray[i] > randomArray[maxIndex]) {
                maxIndex = i;
            }
            if (randomArray[i] < randomArray[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("Minimal element of the array is: " + randomArray[minIndex]);
        System.out.println("Maximal element of the array is: " + randomArray[maxIndex]);

        int temp = randomArray[maxIndex];
        randomArray[maxIndex] = randomArray[minIndex];
        randomArray[minIndex] = temp;

        System.out.println("Random generated array after min and max elements replacement is:\n" + Arrays.toString(randomArray));
    }
}