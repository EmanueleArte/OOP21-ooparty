package minigames.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TestMinigame {

	@Test
	void testScoreMapper() {
		List<String> players = List.of("Luca", "Giovanni", "Lorenzo", "Marco");
		List<Integer> scores = List.of(4, 7, 5, 2);
		
		class MinigameImpl<U> extends MinigameAbstr<U> {

			public MinigameImpl(List<U> players) {
				super(players);
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
			
		}
		
		MinigameImpl<String> m = new MinigameImpl<String>();
		Map<String, Integer> simpleMap = Map.of("Luca", 4, "Giovanni", 7, "Lorenzo", 5, "Marco", 2);
		m.setPlayersClassification(simpleMap);
		List<String> orderedList = List.of("Giovanni", "Lorenzo", "Luca", "Marco");
		assertEquals(orderedList, m.gameResults());
		Map<String, Integer> duplMap = Map.of("Luca", 2, "Giovanni", 7, "Lorenzo", 2, "Marco", 6);
		m.setPlayersClassification(duplMap);
		List<String> orderedDuplList = List.of("Giovanni", "Marco", "Luca", "Lorenzo");
		assertEquals(orderedDuplList, m.gameResults());
	}

}
