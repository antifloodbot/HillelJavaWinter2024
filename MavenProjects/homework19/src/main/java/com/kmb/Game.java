package com.kmb;

import java.util.Scanner;

public class Game {
    private Player player;
    private Computer computer;
    private Scanner scanner;
    private int playedGamesCount = 0;

    public Game(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
        this.computer = new Computer();
    }

    public void playMultipleGames(int numGames) {
        int playedGames = 0;
        while (playedGames < numGames) {
            playGame();
            playedGames++;

            if (playedGames < numGames) {
                System.out.println("Do you want to continue game? (y/n)");
                String continueInput = scanner.nextLine();
                if (!continueInput.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
        playedGamesCount += playedGames;
    }

    private void playGame() {
        Move playerMove = getPlayerMove();
        Move computerMove = computer.getMove();

        System.out.println("Your choice: " + playerMove);
        System.out.println("Computer choice: " + computerMove);

        if (playerMove == computerMove) {
            player.incrementDraws();
            System.out.println("DRAW!");
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
                (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
                (playerMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            player.incrementWins();
            System.out.println("YOU WIN!");
        } else {
            player.incrementLosses();
            System.out.println("YOU LOOSE!");
        }
    }

    private Move getPlayerMove() {
        int choice;
        while (true) {
            System.out.println("Choose your move:");
            System.out.println("1. ROCK");
            System.out.println("2. SCISSORS");
            System.out.println("3. PAPER");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Incorrect choice. Please try again:");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. please enter digit from 1 to 3:");
            }
        }
        return switch (choice) {
            case 1 -> Move.ROCK;
            case 2 -> Move.SCISSORS;
            case 3 -> Move.PAPER;
            default -> null;
        };
    }

    public int getPlayedGamesCount() {
        return playedGamesCount;
    }
}

