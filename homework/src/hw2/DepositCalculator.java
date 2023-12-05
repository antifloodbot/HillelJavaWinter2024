package hw2;
/*Програму, яка пропонує користувачеві запровадити суму грошового вкладу у гривнях,
відсоток річних, які виплачує банк, тривалість вкладу (років).
Вивести накопичену суму грошей за кожен рік та нараховані відсотки.
(Відсотки складні з капіталізацією щомісяця)

У завданні 3 числа вводити через аргументи програми

приклад
java DepositCalculator <сума> <відсоток> <тривалість_у_роках>*/

public class DepositCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Потрібно ввести 3 аргументи - суму грошового вкладу, відсоток річних та тривалість вкладу у роках");
            return;
        }

        double initialDeposit = Double.parseDouble(args[0]);
        double annualPercentRate = Double.parseDouble(args[1]);
        int termInYears = Integer.parseInt(args[2]);

        double monthlyPercentRate = (annualPercentRate / 100) / 12;

        System.out.println("Рік\tНакопичена сума\tНараховані відсотки");

        for (int year = 1; year <= termInYears; year++) {
            double totalAnnual = 0;
            for (int month = 1; month <= 12; month++) {
                double monthlyPercentAccumulated = initialDeposit * monthlyPercentRate;
                totalAnnual += monthlyPercentAccumulated;
                initialDeposit += monthlyPercentAccumulated;
            }
            System.out.printf("%d\t%.2f\t%.2f\n", year, initialDeposit, totalAnnual);
        }
    }
}
