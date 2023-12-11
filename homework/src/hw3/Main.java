package hw3;

public class Main {
    public static void main(String[] args) {
        Homework3 hw = new Homework3();

        System.out.println("Task 1: Using a for loop, display the odd numbers from 1 to 99.");
        hw.forPrintFrom1to99();

        System.out.println("\nTask 3.1: Using a while loop, display the odd numbers from 1 to 99.");
        hw.whilePrintFrom1to99();

        System.out.println("\nTask 3.2: Using a do while loop, display the odd numbers from 1 to 99.");
        hw.doWhilePrintFrom1to99();

        System.out.println("\nTask 2: Given a number n, calculate the factorial of n using a for loop.");
        hw.forCalculateFactorial(5);

        System.out.println("Task 4.1: Given a number n, calculate the factorial of n using a while loop.");
        hw.whileCalculateFactorial(5);

        System.out.println("Task 4.2: Given a number n, calculate the factorial of n using a do while loop.");
        hw.doWhileCalculateFactorial(5);

        System.out.println("Task 5: Given variables x and n, compute x^n.");
        hw.calculateExponentialExpression(-4,3);

        System.out.println("Task 6: Output the first 10 numbers of the sequence 0, -5, -10, -15.");
        hw.outputFirst10Numbers();

        System.out.println("\nTask 7: It is necessary to display the multiplication table for X: (any number entered from the console).");
        hw.multiplicationTable();

        System.out.println("Task 8: Create an array that contains the first 10 odd numbers. Print the elements of the array to the console in one line, separating them with a comma.");
        hw.oddNumbersArray();

        System.out.println("\nTask 9: Given an array of size N, find the smallest element of the array and print it to the console.");
        hw.smallestNumberOfTheArray();

        System.out.println("Task 10: Given an array of size N, find the biggest element of the array and print it to the console.");
        hw.biggestNumberOfTheArray();

        System.out.println("Task 11: Swap the maximum and minimum elements in the array");
        hw.swapMaximalAndMinimalDigitInTheArray();
    }
}
