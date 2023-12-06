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
        try {
            if(args.length !=3) {
                throw new IllegalArgumentException("Please enter initial deposit amount, annual percent rate and term of deposit in years.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        double initialDeposit = Double.parseDouble(args[0]);
        double annualPercentRate = Double.parseDouble(args[1]);
        int termInYears = Integer.parseInt(args[2]);

        double monthlyPercentRate = (annualPercentRate / 100) / 12;

        System.out.println("Year\tAccumulated amount\taccumulated %");

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
