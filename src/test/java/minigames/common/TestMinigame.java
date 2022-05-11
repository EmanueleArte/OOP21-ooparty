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
		List<Optional<String>> players = List.of(Optional.of("Luca"), Optional.of("Giovanni"), 
				Optional.of("Lorenzo"), Optional.of("Marco"));
		List<Integer> scores = List.of(4, 7, 5, 2);
		
		class MinigameImpl<U> extends MinigameAbstr<U> {

			public MinigameImpl(final List<U> players) {
				super(players);
			}
			
		}
		
		MinigameImpl<Optional<String>> m = new MinigameImpl<Optional<String>>(players);
		players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
		Map<Optional<String>, Integer> correctMap = Map.of(Optional.of("Luca"), 4, Optional.of("Giovanni"), 7, 
				Optional.of("Lorenzo"), 5, Optional.of("Marco"), 2);
		assertEquals(correctMap, m.getPlayersClassification());
	}

	
	@Test
	void testSortPlayerByScore() {
		class MinigameImpl<U> extends MinigameAbstr<U> {
			
			public MinigameImpl() {
				super();
			}
			
		}
		
		MinigameImpl<Optional<String>> m = new MinigameImpl<Optional<String>>();
		Map<Optional<String>, Integer> simpleMap = Map.of(Optional.of("Luca"), 4, Optional.of("Giovanni"), 7, 
				Optional.of("Lorenzo"), 5, Optional.of("Marco"), 2);
		m.setPlayersClassification(simpleMap);
		List<Optional<String>> orderedList = List.of(Optional.of("Giovanni"), Optional.of("Lorenzo"), 
				Optional.of("Luca"), Optional.of("Marco"));
		assertEquals(orderedList, m.gameResults());
		/*Map<Optional<String>, Integer> duplMap = Map.of(Optional.of("Luca"), 2, Optional.of("Giovanni"), 7, 
				Optional.of("Lorenzo"), 2, Optional.of("Marco"), 6);
		m.setPlayersClassification(duplMap);
		List<Optional<String>> orderedDuplList = List.of(Optional.of("Giovanni"), Optional.of("Marco"), 
				Optional.of("Luca"), Optional.of("Lorenzo"));
		assertEquals(orderedDuplList, m.gameResults());*/
	}

}
