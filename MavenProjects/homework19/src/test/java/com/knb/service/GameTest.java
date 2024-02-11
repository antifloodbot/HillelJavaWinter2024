package com.knb.service;

import com.knb.dto.Move;
import com.knb.dto.Outcome;
import com.knb.dto.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @ParameterizedTest
    @CsvSource({
            "ROCK, ROCK, DRAW",
            "PAPER, PAPER, DRAW",
            "SCISSORS, SCISSORS, DRAW",
            "ROCK, SCISSORS, WIN",
            "PAPER, ROCK, WIN",
            "SCISSORS, PAPER, WIN",
            "ROCK, PAPER, LOSE",
            "PAPER, SCISSORS, LOSE",
            "SCISSORS, ROCK, LOSE"
    })
    void testGetResult2(Move playerMove, Move computerMove, Outcome expectedOutcome) {
        Player player = new Player("TestPlayer");
        Game game = new Game(player);

        assertEquals(expectedOutcome, game.getResult(playerMove, computerMove));
    }

    @Test
    void testNullMoves() {
        Player player = new Player("TestPlayer");
        Game game = new Game(player);

        assertThrows(IllegalArgumentException.class, () -> {
            game.getResult(null, Move.PAPER);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.getResult(Move.ROCK, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.getResult(null, null);
        });
    }
}