package minigames.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import game.dice.model.DiceModelNoRepeatImpl;
import game.player.Player;
import game.player.PlayerImpl;
import minigames.cutFromTheTeam.model.CutFromTheTeamModel;
import minigames.cutFromTheTeam.model.CutFromTheTeamModelImpl;

/**
 * Test class for CutFromTheTeamModelImpl.
 */
public class TestCutFromTheTeamModel {

    private List<Player> players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));
    private CutFromTheTeamModel m = new CutFromTheTeamModelImpl(players, new DiceModelNoRepeatImpl());
    private final List<Integer> scores = List.of(4, 7);
    private final List<Integer> scoresDupl = List.of(7, 7);

    static final int SCORE_FOR_GUESSED_PAIR = 1;

    @Test
    void testIsOver() {
        assertFalse(this.m.isOver());
        this.m.runGame();
        assertFalse(this.m.isOver());
        this.m.setRope(true);
        this.m.runGame();
        assertTrue(this.m.isOver());
    }

    @Test
    private void testChangeTurn() {

    }

    @Test
    void testScoreMapper() {
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final Map<Player, Integer> correctMap = Map.of(new PlayerImpl("Luca"), 4, new PlayerImpl("Giovanni"), 7);
        assertEquals(correctMap, m.getPlayersClassification());
    }

    @Test
    void testSortPlayerByScore() {
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final List<Player> orderedList = List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Luca"));
        assertEquals(List.of(orderedList), List.of(m.getGameResults()));
    }

    @Test
    void testSortPlayerByScoreWithDraws() {
        players.forEach(p -> m.scoreMapper(p, scoresDupl.get(players.indexOf(p))));
        List<List<Player>> orderedDuplList = List.of(List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni")),
                List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Luca")));
        assertTrue(orderedDuplList.contains(m.getGameResults()));
    }

}
