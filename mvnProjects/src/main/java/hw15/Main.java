package hw15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValidInput;
        System.out.println("Please enter any number using digits from 0 to 9 eg 0123456789: ");

        do {
            input = scanner.nextLine();
            isValidInput = input.matches("[0-9]+");
            if (!isValidInput) {
                System.out.println("Invalid Input. Please enter any number using digits from 0 to 9 eg 0123456789: ");
            }
        } while (!isValidInput);

        PseudoGraphicsGenerator generator = new PseudoGraphicsGenerator();
        generator.printPseudoGraphic(input);
    }
}
