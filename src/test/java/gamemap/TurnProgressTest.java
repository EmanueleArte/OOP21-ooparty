package gamemap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;

class TurnProgressTest {

    @Test
    void testTurnProgressEndOfTurn() {
        TurnProgress t = TurnProgress.SHOW_BANNER;
        t = TurnProgress.next(t);
        t = TurnProgress.next(t);
        t = TurnProgress.next(t);
        t = TurnProgress.next(t);
        t = TurnProgress.next(t);
        assertEquals(TurnProgress.END_OF_TURN, t);
        t = TurnProgress.next(t);
        assertEquals(TurnProgress.SHOW_BANNER, t);
    }

    @Test
    void testPlayerTurnProgressEndOfTurn() {
        PlayerTurnProgress p = PlayerTurnProgress.SHOW_BANNER;
        p = PlayerTurnProgress.next(p);
        p = PlayerTurnProgress.next(p);
        p = PlayerTurnProgress.next(p);
        p = PlayerTurnProgress.next(p);
        assertEquals(PlayerTurnProgress.END_OF_TURN, p);
        p = PlayerTurnProgress.next(p);
        assertEquals(PlayerTurnProgress.SHOW_BANNER, p);
    }

}
