package com.hillel.blackjack.service;

import com.hillel.blackjack.exception.NotEnoughtMoneyException;

import java.util.Scanner;

public class MoneyService {
    public Integer validateBet(Integer bet, Integer amount) {

        if (amount <= 0){
            throw new NotEnoughtMoneyException("game over... RIP");
        }
        if (bet > amount) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.printf("You can put %s $. Continue [Y/N]%n", amount);
                String des = scanner.nextLine();

                if (!des.equalsIgnoreCase("y")) {
                    System.out.println("Please put your new bet:");
                    bet = scanner.nextInt();
                    scanner.nextLine();
                    validateBet(bet, amount);
                } else {
                    bet = amount;
                }
            }
        }
        return bet;
    }
}
