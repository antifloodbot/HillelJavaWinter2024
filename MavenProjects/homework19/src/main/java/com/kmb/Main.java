package com.kmb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        do {
            System.out.println("Please enter your name:");
            playerName = scanner.nextLine().trim();
        } while (playerName.isEmpty());

        Player player = new Player(playerName);

        int numGames;
        do {
            System.out.println("How many games do you want to play?");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number:");
                scanner.next();
            }
            numGames = scanner.nextInt();
        } while (numGames <= 0);

        scanner.nextLine();
        System.out.println("Game starts, " + player.getName() + "!");

        Game game = new Game(player, scanner);
        game.playMultipleGames(numGames);

        System.out.println("Thanks for the game, " + player.getName() + "!");
        System.out.println("Results:");
        System.out.println("Games played: " + game.getPlayedGamesCount());
        System.out.println("WON: " + player.getWins());
        System.out.println("LOOSE: " + player.getLosses());
        System.out.println("DRAW: " + player.getDraws());

        scanner.close();
    }
}

