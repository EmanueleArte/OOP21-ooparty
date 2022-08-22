package gamemap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;

class TurnProgressTest {

    @Test
    void testTurnProgressNext() {
        TurnProgress t = TurnProgress.SHOW_LEADERBOARD;
        t = TurnProgress.next(t);
        assertEquals(TurnProgress.END_OF_TURN, t);
        t = TurnProgress.next(t);
        assertEquals(TurnProgress.SHOW_BANNER, t);
    }

    @Test
    void testPlayerTurnProgressNext() {
        PlayerTurnProgress p = PlayerTurnProgress.MOVE_PLAYER;
        p = PlayerTurnProgress.next(p);
        assertEquals(PlayerTurnProgress.END_OF_TURN, p);
        p = PlayerTurnProgress.next(p);
        assertEquals(PlayerTurnProgress.SHOW_BANNER, p);
    }

    @Test
    void testPlayerTurnProgressPrevious() {
        PlayerTurnProgress p = PlayerTurnProgress.SHOW_BANNER;
        p = PlayerTurnProgress.previous(p);
        assertEquals(PlayerTurnProgress.END_OF_TURN, p);
        p = PlayerTurnProgress.previous(p);
        assertEquals(PlayerTurnProgress.MOVE_PLAYER, p);
    }

}
