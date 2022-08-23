package minigames;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import game.dice.model.DiceModelNoRepeatImpl;
import game.player.Player;
import game.player.PlayerImpl;
import minigames.cutFromTheTeam.model.CutFromTheTeamModelImpl;

/**
 * Test class for CutFromTheTeamModelImpl.
 */
public class TestCutFromTheTeamModel {

    private List<Player> players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));

    static final int SCORE_FOR_GUESSED_PAIR = 1;

    @Test
    void testIsOver() {
        final var m = new CutFromTheTeamModelImpl(players, new DiceModelNoRepeatImpl());

        assertFalse(m.isOver());
        m.runGame();
        assertFalse(m.isOver());
        m.setRope(true);
        assertThrows(new IllegalStateException().getClass(), () -> m.runGame());
        assertTrue(m.isOver());
    }

    @Test
    void testChangeTurn() {
        final var m = new CutFromTheTeamModelImpl(players, new DiceModelNoRepeatImpl());

        assertEquals(m.getCurrPlayer().getNickname(), players.get(0).getNickname());
        m.runGame();
        assertEquals(m.getCurrPlayer().getNickname(), players.get(0).getNickname());
        m.setRope(false);
        m.runGame();
        assertEquals(m.getCurrPlayer().getNickname(), players.get(1).getNickname());
        m.setRope(true);
        assertThrows(new IllegalStateException().getClass(), () -> m.runGame());
    }

}
