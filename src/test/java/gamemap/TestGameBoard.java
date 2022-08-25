package gamemap;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import game.map.CoinsGameMapSquare;
import game.map.DamageGameMapSquare;
import game.map.GameMapSquareImpl;
import game.map.PowerUpGameMapSquare;
import game.map.StarGameMapSquare;
import utils.factories.board.GameBoardFactory;
import utils.factories.board.SimpleGameBoardFactory;

class TestGameBoard {

    @Test
    void testFirstSquare() {
        GameBoardFactory factory = new SimpleGameBoardFactory();
        var board = factory.createGameBoard();
        assertEquals(GameMapSquareImpl.class, board.get(0).getClass());
    }

    @Test
    void testSize() {
        GameBoardFactory factory = new SimpleGameBoardFactory();
        var board = factory.createGameBoard();
        assertEquals(factory.getSize(), board.size());
    }

    @Test
    void testStarsCount() {
        GameBoardFactory factory = new SimpleGameBoardFactory();
        var board = factory.createGameBoard();

        var starsCount = board.stream()
            .filter(s -> s.getClass().equals(StarGameMapSquare.class))
            .map(s -> 1)
            .reduce((r, e) -> r + e);

        assertTrue(starsCount.isPresent());
        assertEquals(SimpleGameBoardFactory.maxOccurrences().get(StarGameMapSquare.class), starsCount.get());
    }

    @Test
    void testCoinsCount() {
        GameBoardFactory factory = new SimpleGameBoardFactory();
        var board = factory.createGameBoard();

        var coinsCount = board.stream()
            .filter(s -> s.getClass().equals(CoinsGameMapSquare.class))
            .map(s -> 1)
            .reduce((r, e) -> r + e);

        assertTrue(coinsCount.isPresent());
        assertEquals(SimpleGameBoardFactory.maxOccurrences().get(CoinsGameMapSquare.class), coinsCount.get());
    }

    @Test
    void testDamagesCount() {
        GameBoardFactory factory = new SimpleGameBoardFactory();
        var board = factory.createGameBoard();

        var damagesCount = board.stream()
            .filter(s -> s.getClass().equals(DamageGameMapSquare.class))
            .map(s -> 1)
            .reduce((r, e) -> r + e);

        assertTrue(damagesCount.isPresent());
        assertEquals(SimpleGameBoardFactory.maxOccurrences().get(DamageGameMapSquare.class), damagesCount.get());
    }

    @Test
    void testPowerUpsCount() {
        GameBoardFactory factory = new SimpleGameBoardFactory();
        var board = factory.createGameBoard();

        var powerUpsCount = board.stream()
            .filter(s -> s.getClass().equals(PowerUpGameMapSquare.class))
            .map(s -> 1)
            .reduce((r, e) -> r + e);

        assertTrue(powerUpsCount.isPresent());
        assertEquals(SimpleGameBoardFactory.maxOccurrences().get(PowerUpGameMapSquare.class), powerUpsCount.get());
    }
}
