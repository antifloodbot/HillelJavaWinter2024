package hw2;

/*
 * Програма, яка знаходить середнє арифметичне значення двох чисел.
 */
public class AverageOfTwo {
    public static void main(String[] args) {
        try {
            if(args.length != 2){
                throw new IllegalArgumentException("Need to use 2 digital arguments");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            double db1 = Double.parseDouble(args[0]);
            double db2 = Double.parseDouble(args[1]);
            double result = (db1 + db2) / 2;
            System.out.println("Average of two digits is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Both arguments should be digits.");
        }
    }
}
