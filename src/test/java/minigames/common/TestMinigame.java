package minigames.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import minigames.common.model.MinigameModelAbstr;

/**
 * Test class for MinigameModelAbstr.
 */
class TestMinigame {

    private final List<String> players = List.of("Luca", "Giovanni", "Lorenzo", "Marco");
    private final List<Integer> scores = List.of(4, 7, 5, 2);

    class MinigameModelImpl<S, U> extends MinigameModelAbstr<S, U> {

        MinigameModelImpl(final List<U> players) {
            super(players);
        }

        @Override
        public void runGame() {
        }

    }

    @Test
    void testScoreMapper() {
        final MinigameModelImpl<Integer, String> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final Map<String, Integer> correctMap = Map.of("Luca", 4, "Giovanni", 7, "Lorenzo", 5, "Marco", 2);
        assertEquals(correctMap, m.getPlayersClassification());
    }

    @Test
    void testSortPlayerByScore() {
        final MinigameModelImpl<Integer, String> m = new MinigameModelImpl<>(players);
        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final List<String> orderedList = List.of("Giovanni", "Lorenzo", "Luca", "Marco");
        assertEquals(orderedList, m.gameResults());
        /*
         * Map<Optional<String>, Integer> duplMap = Map.of(Optional.of("Luca"), 2,
         * Optional.of("Giovanni"), 7, Optional.of("Lorenzo"), 2, Optional.of("Marco"),
         * 6); m.setPlayersClassification(duplMap); List<Optional<String>>
         * orderedDuplList = List.of(Optional.of("Giovanni"), Optional.of("Marco"),
         * Optional.of("Luca"), Optional.of("Lorenzo")); assertEquals(orderedDuplList,
         * m.gameResults());
         */
    }

}
