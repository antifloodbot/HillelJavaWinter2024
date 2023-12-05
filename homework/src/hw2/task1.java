package hw2;

/*
 * Програма, яка знаходить середнє арифметичне значення двох чисел.
 */
public class task1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Потрібно передати два числові аргументи.");
            return;
        }

        try {
            double db1 = Double.parseDouble(args[0]);
            double db2 = Double.parseDouble(args[1]);
            double result = (db1 + db2) / 2;
            System.out.println("Середнє арифметичне двох чисел: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Обидва аргументи мають бути числами.");
        }
    }
}
