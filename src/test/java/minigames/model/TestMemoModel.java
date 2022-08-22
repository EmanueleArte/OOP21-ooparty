package minigames.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import game.dice.model.DiceModelNoRepeatImpl;
import game.player.Player;
import game.player.PlayerImpl;
import minigames.memo.model.MemoModel;
import minigames.memo.model.MemoModelImpl;

/**
 * Test class for MemoModelImpl.
 */
class TestMemoModel {

    private List<Player> players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));
    private MemoModel m = new MemoModelImpl(players, new DiceModelNoRepeatImpl());
    private final List<Integer> scores = List.of(4, 7);
    private final List<Integer> scoresDupl = List.of(7, 7);

    static final int NUMBER_OF_PAIRS_PER_PLAYER = 5;
    static final int SCORE_FOR_GUESSED_PAIR = 1;

    @Test
    void testIsOver() {
        assertFalse(this.m.isOver());
        IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.players.size()).boxed().map(i -> Stream.of(i, i))
                .forEach(s -> {
                    s.forEach(this.m::setValue);
                    this.m.runGame();
                });
        assertTrue(this.m.isOver());
    }

    @Test
    void testGetCurrPlayer() {
        assertEquals(this.m.getCurrPlayer(), this.players.get(0));
        this.m.setValue(0);
        assertEquals(this.m.getCurrPlayer(), this.players.get(0));
        this.m.setValue(1);
        this.m.runGame();

        assertEquals(this.m.getCurrPlayer(), this.players.get(1));
        this.m.setValue(0);
        assertEquals(this.m.getCurrPlayer(), this.players.get(1));
        this.m.setValue(1);
        this.m.runGame();

        assertEquals(this.m.getCurrPlayer(), this.players.get(0));
        this.m.setValue(0);
        assertEquals(this.m.getCurrPlayer(), this.players.get(0));
        this.m.setValue(0);
        this.m.runGame();

        assertEquals(this.m.getCurrPlayer(), this.players.get(0));
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
