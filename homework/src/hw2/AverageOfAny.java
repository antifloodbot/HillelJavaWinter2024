package hw2;

/*
Програма, яка знаходить середнє арифметичне значення довільної кількості чисел.
*/
public class AverageOfAny {
    public static void main(String[] args) {
        int count = args.length;
        double sum = 0;

        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Need to enter at leas one digital argument");
            }
            try {
                for (String arg : args) {
                    sum += Double.parseDouble(arg);
                }
                double average = sum / count;
                System.out.println("Average of " + count + " digits is: " + average);
            } catch (IllegalArgumentException e) {
                System.out.println("All arguments should be digits.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
