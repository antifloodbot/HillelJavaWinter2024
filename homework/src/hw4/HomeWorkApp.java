package hw4;

public class HomeWorkApp {
    public static void main(String[] args) {
        Methods methods = new Methods();

        System.out.println("Task 2: print three words:");
        methods.printThreeWords();

        System.out.println("\nTask 3: check sum sign:");
        methods.checkSumSign(-20,10);

        System.out.println("\nTask 4: print color");
        methods.printColor(101);

        System.out.println("\nTask 5: compare numbers");
        methods.compareNumbers(-2,1);

        System.out.println("\nTask 6: sum between 10-20");
        methods.compareSumOfNumbers(15,5);

        System.out.println("\nTask 7: check digit is positive or negative");
        methods.printNumberSign(-1);

        System.out.println("\nTask 8: return true if digit is negative and return false if digit is positive");
        methods.isNegative(-1);

        System.out.println("\nTask 9: print string n times");
        methods.printStringMultipleTimes("Java", 3);

        System.out.println("\nTask 10: check if year is leap");
        methods.isYearLeap(400);
    }
}