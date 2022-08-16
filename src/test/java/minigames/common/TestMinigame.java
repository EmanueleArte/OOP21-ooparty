package minigames.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import game.player.Player;
import game.player.PlayerImpl;
import minigames.common.model.MinigameModel;
import minigames.common.model.MinigameModelAbstr;

/**
 * Test class for MinigameModelAbstr.
 */
class TestMinigame {

    private final List<Player> players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"),
            new PlayerImpl("Lorenzo"), new PlayerImpl("Marco"));
    private final List<Integer> scores = List.of(4, 7, 5, 2);
    private final List<Integer> scoresDupl = List.of(2, 7, 2, 5);

    class MinigameModelImpl<S> extends MinigameModelAbstr<S> {

        MinigameModelImpl(final List<Player> players) {
            super(players);
        }

        @Override
        public boolean runGame() {
            return false;
        }

    }

    @Test
    void testScoreMapper() {
        final MinigameModel<Integer> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final Map<Player, Integer> correctMap = Map.of(new PlayerImpl("Luca"), 4, new PlayerImpl("Giovanni"), 7,
                new PlayerImpl("Lorenzo"), 5, new PlayerImpl("Marco"), 2);
        assertEquals(correctMap, m.getPlayersClassification());
    }

    @Test
    void testSortPlayerByScore() {
        final MinigameModel<Integer> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final List<Player> orderedList = List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Lorenzo"),
                new PlayerImpl("Luca"), new PlayerImpl("Marco"));
        assertEquals(orderedList, m.gameResults());
    }

    @Test
    void testSortPlayerByScoreWithDraws() {
        final MinigameModel<Integer> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scoresDupl.get(players.indexOf(p))));
        List<List<Player>> orderedDuplList = List.of(
                List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Marco"), new PlayerImpl("Luca"),
                        new PlayerImpl("Lorenzo")),
                List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Marco"), new PlayerImpl("Lorenzo"),
                        new PlayerImpl("Luca")));
        assertTrue(orderedDuplList.contains(m.gameResults()));

    }

}
