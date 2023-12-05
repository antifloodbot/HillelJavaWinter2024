package hw2;

/*
Програма, яка знаходить середнє арифметичне значення довільної кількості чисел.
*/
public class task2 {
    public static void main(String[] args) {
        int count = args.length;
        double sum = 0;

        if (args.length == 0) {
            System.out.println("Потрібно ввести хоча б одне число як аргумент");
            return;
        }

        try {
            for (String arg : args) {
                sum += Double.parseDouble(arg);
            }
            double average = sum / count;
            System.out.println("Середнє арифметичне " + count + " чисел: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Всі аргументи мають бути числами.");
        }
    }
}
