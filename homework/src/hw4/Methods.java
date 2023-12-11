package hw4;

public class Methods<i> {
    public void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public void checkSumSign(int a, int b) {
        System.out.println((a + b >= 0) ? "Sum is positive" : "Sum is negative");
    }

    public void printColor(int i) {
        if (i < 0) {
            System.out.println("Red");
        } else if (i <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    public void compareNumbers(int a, int b) {
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    public void compareSumOfNumbers(int a, int b) {
        System.out.println(a + b >= 10 && a + b <= 20);
    }

    public void printNumberSign(int a) {
        System.out.println((a >= 0) ? "Digit is positive" : "Digit is negative");
    }

    public void isNegative(int a) {
        System.out.println(a < 0);
    }

    public void printStringMultipleTimes(String text, int multiplier) {
        if (multiplier > 0) {
            for (int i = 0; i < multiplier; i++) {
                System.out.println(text);
            }
        } else {
            System.out.println("Multiplier should be more than 0");
        }
    }

    public void isYearLeap(int year) {
        boolean isLeap = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
        System.out.println(isLeap);
    }
}
