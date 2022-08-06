package minigames.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import minigames.common.model.MinigameModel;
import minigames.common.model.MinigameModelAbstr;

/**
 * Test class for MinigameModelAbstr.
 */
class TestMinigame {

    private final List<String> players = List.of("Luca", "Giovanni", "Lorenzo", "Marco");
    private final List<Integer> scores = List.of(4, 7, 5, 2);
    private final List<Integer> scoresDupl = List.of(2, 7, 2, 5);

    class MinigameModelImpl<S, U> extends MinigameModelAbstr<S, U> {

        MinigameModelImpl(final List<U> players) {
            super(players);
        }

        @Override
        public boolean runGame() {
            return false;
        }

    }

    @Test
    void testScoreMapper() {
        final MinigameModel<Integer, String> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final Map<String, Integer> correctMap = Map.of("Luca", 4, "Giovanni", 7, "Lorenzo", 5, "Marco", 2);
        assertEquals(correctMap, m.getPlayersClassification());
    }

    @Test
    void testSortPlayerByScore() {
        final MinigameModel<Integer, String> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final List<String> orderedList = List.of("Giovanni", "Lorenzo", "Luca", "Marco");
        assertEquals(orderedList, m.gameResults());
        players.forEach(p -> m.scoreMapper(p, scoresDupl.get(players.indexOf(p))));
        List<List<String>> orderedDuplList = List.of(List.of("Giovanni", "Marco", "Luca", "Lorenzo"), List.of("Giovanni", "Marco", "Lorenzo", "Luca"));
        assertTrue(orderedDuplList.contains(m.gameResults()));

    }

}
