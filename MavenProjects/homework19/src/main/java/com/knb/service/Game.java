package com.knb.service;

import com.knb.dto.Computer;
import com.knb.dto.Move;
import com.knb.dto.Outcome;
import com.knb.dto.Player;
import com.knb.exceptions.IncorrectChoiceException;

import java.util.Scanner;

public class Game {
    private Player player;
    private Computer computer;
    private Scanner scanner;
    private int playedGamesCount = 0;
    private int roundNumber = 0;

    public Game(Player player) {
        this.player = player;
    }

    private static final Outcome[][] RESULTS_MATRIX = {
            {Outcome.DRAW, Outcome.WIN, Outcome.LOSE},
            {Outcome.LOSE, Outcome.DRAW, Outcome.WIN},
            {Outcome.WIN, Outcome.LOSE, Outcome.DRAW}
    };

    public Game(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
        this.computer = new Computer();
    }

    public void playMultipleGames(int numGames) {
        int playedGames = 0;
        while (playedGames < numGames) {
            System.out.println("Game starts, " + player.getName() + "!");
            System.out.println("Game: " + (roundNumber + 1) + "/" + numGames);

            playGame();
            roundNumber++;
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

    public void playGame() {
        Move playerMove = getPlayerMove();
        Move computerMove = computer.getMove();

        System.out.println("Your move: " + playerMove);
        System.out.println("Computer move: " + computerMove);

        Outcome result = getResult(playerMove, computerMove);
        switch (result) {
            case WIN:
                player.incrementWins();
                System.out.println("YOU WIN!");
                break;
            case LOSE:
                player.incrementLosses();
                System.out.println("YOU LOSE!");
                break;
            case DRAW:
                player.incrementDraws();
                System.out.println("DRAW!");
                break;
        }
    }

    private Move getPlayerMove() {
        int choice;
        while (true) {
            System.out.println("Choose your move:");
            System.out.println("1. ROCK");
            System.out.println("2. SCISSORS");
            System.out.println("3. PAPER");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 3) {
                    throw new IncorrectChoiceException("Incorrect input. Please enter digit from 1 to 3:");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Please enter digit from 1 to 3:");
            } catch (IncorrectChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
        switch (choice) {
            case 1:
                return Move.ROCK;
            case 2:
                return Move.SCISSORS;
            case 3:
                return Move.PAPER;
            default:
                return null;
        }
    }

    public int getPlayedGamesCount() {
        return playedGamesCount;
    }

    Outcome getResult(Move playerMove, Move computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Both playerMove and computerMove must be non-null");
        }

        return RESULTS_MATRIX[playerMove.ordinal()][computerMove.ordinal()];
    }
}

