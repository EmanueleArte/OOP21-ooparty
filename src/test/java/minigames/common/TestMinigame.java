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
		Map<String, Integer> correctMap = new HashMap<>();
		players.forEach(p -> correctMap.put(p, scores.get(players.indexOf(p))));
		assertEquals(correctMap, m.getPlayersClassification());
	}

	
	@Test
	void testSortPlayerByScore() {
		
	}

}
