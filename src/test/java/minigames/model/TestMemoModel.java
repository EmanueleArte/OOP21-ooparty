package minigames.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import game.dice.model.DiceModelNoRepeatImpl;
import game.player.Player;
import game.player.PlayerImpl;
import minigames.memo.model.MemoModelImpl;

/**
 * Test class for MemoModelImpl.
 */
class TestMemoModel {

    private List<Player> players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));

    static final int NUMBER_OF_PAIRS_PER_PLAYER = 4;
    static final int SCORE_FOR_GUESSED_PAIR = 1;

    @Test
    void testIsOver() {
        final var m = new MemoModelImpl(players, new DiceModelNoRepeatImpl());

        assertFalse(m.isOver());
        IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.players.size()).boxed().map(i -> Stream.of(i, i))
                .forEach(s -> {
                    s.forEach(m::setValue);
                    m.runGame();
                });
        assertTrue(m.isOver());
    }

    @Test
    void testGetCurrPlayer() {
        final var m = new MemoModelImpl(players, new DiceModelNoRepeatImpl());

        assertEquals(this.players.get(0), m.getCurrPlayer());
        m.setValue(0);
        assertEquals(this.players.get(0), m.getCurrPlayer());
        m.setValue(1);
        m.runGame();

        assertEquals(this.players.get(1), m.getCurrPlayer());
        m.setValue(0);
        assertEquals(this.players.get(1), m.getCurrPlayer());
        m.setValue(1);
        m.runGame();

        assertEquals(this.players.get(0), m.getCurrPlayer());
        m.setValue(0);
        assertEquals(this.players.get(0), m.getCurrPlayer());
        m.setValue(0);
        m.runGame();

        assertEquals(this.players.get(0), m.getCurrPlayer());
    }

}
