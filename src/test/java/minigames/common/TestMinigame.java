package minigames.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class TestMinigame {

	@Test
	void testScoreMapper() {
		List<String> players = List.of("Luca", "Giovanni", "Lorenzo", "Marco");
		List<Integer> scores = List.of(4, 7, 5, 2);
		
		class MinigameImpl<U> extends MinigameAbstr<U> {

			public MinigameImpl(final List<U> players) {
				super(players);
			}

			@Override
			public List<U> runGame() {
				return null;
			}
			
		}
		
		MinigameImpl<String> m = new MinigameImpl<String>(players);
		players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
		Map<String, Integer> correctMap = Map.of("Luca", 4, "Giovanni", 7, "Lorenzo", 5, "Marco", 2);
		assertEquals(correctMap, m.getPlayersClassification());
	}

	
	@Test
	void testSortPlayerByScore() {
		class MinigameImpl<U> extends MinigameAbstr<U> {
			
			public MinigameImpl() {
				super();
			}

			@Override
			public List<U> runGame() {
				return null;
			}
			
		}
		
		MinigameImpl<String> m = new MinigameImpl<String>();
		Map<String, Integer> simpleMap = Map.of("Luca", 4, "Giovanni", 7, "Lorenzo", 5, "Marco", 2);
		m.setPlayersClassification(simpleMap);
		List<String> orderedList = List.of("Giovanni", "Lorenzo", "Luca", "Marco");
		assertEquals(orderedList, m.gameResults());
		/*Map<Optional<String>, Integer> duplMap = Map.of(Optional.of("Luca"), 2, Optional.of("Giovanni"), 7, 
				Optional.of("Lorenzo"), 2, Optional.of("Marco"), 6);
		m.setPlayersClassification(duplMap);
		List<Optional<String>> orderedDuplList = List.of(Optional.of("Giovanni"), Optional.of("Marco"), 
				Optional.of("Luca"), Optional.of("Lorenzo"));
		assertEquals(orderedDuplList, m.gameResults());*/
	}

}
