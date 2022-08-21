package minigames.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import game.player.Player;
import game.player.PlayerImpl;
import javafx.scene.Scene;
import minigames.memo.model.MemoModel;
import minigames.memo.model.MemoModelImpl;
import utils.graphics.controller.StageManager;
import utils.graphics.controller.StageManagerImpl;
import utils.graphics.view.JavafxGuiImpl;

/**
 * Test class for MemoModelImpl.
 */
class TestMemoModel {

    private final StageManager<Scene> stageManager = new StageManagerImpl<>("OOparty", JavafxGuiImpl.class);
    private List<Player> players;
    private MemoModel<?> m;
    private final List<Integer> scores = List.of(4, 7);
    private final List<Integer> scoresDupl = List.of(7, 7);

    /*
     * boolean isOver();
     * 
     * This method runs the routine after a card is chosen. If there is no current
     * player, this method sets one.
     * 
     * @param index the index of the chosen card.
     * 
     * @return {@code true} if this card is the second of a pair, {@code false}
     * otherwise.
     * 
     * @throws IndexOutOfBoundsException if the card passed has already been
     * guessed.
     * 
     * @throws IllegalStateException if che game is over.
     * 
     * boolean pickCard(int index);
     * 
     * This method gives back the current player managing whether it does not
     * exists.
     *
     * @return the current player.
     * 
     * Player getCurrPlayer();
     * 
     * This method tells the active cards.
     *
     * @return a list containing the active cards.
     * 
     * List<Integer> getCards();
     */

    @Test
    void testIsOver() {
        this.players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));
        this.m = new MemoModelImpl<>(players, this.stageManager);
    }

    @Test
    void testPickCard() {

    }

    @Test
    void testGetCurrPlayer() {

    }

    @Test
    void testGetCards() {

    }

    @Test
    void testScoreMapper() {
        this.players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));
        this.m = new MemoModelImpl<>(players, this.stageManager);

        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final Map<Player, Integer> correctMap = Map.of(new PlayerImpl("Luca"), 4, new PlayerImpl("Giovanni"), 7);
        assertEquals(correctMap, m.getPlayersClassification());
    }

    @Test
    void testSortPlayerByScore() {
        this.players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));
        this.m = new MemoModelImpl<>(players, this.stageManager);

        players.forEach(p -> m.scoreMapper(p, scores.get(players.indexOf(p))));
        final List<Player> orderedList = List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Luca"));
        assertEquals(List.of(orderedList), List.of(m.getGameResults()));
    }

    @Test
    void testSortPlayerByScoreWithDraws() {
        this.players = List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni"));
        this.m = new MemoModelImpl<>(players, this.stageManager);

        players.forEach(p -> m.scoreMapper(p, scoresDupl.get(players.indexOf(p))));
        List<List<Player>> orderedDuplList = List.of(
                List.of(new PlayerImpl("Luca"), new PlayerImpl("Giovanni")),
                List.of(new PlayerImpl("Giovanni"), new PlayerImpl("Luca")));
        assertTrue(orderedDuplList.contains(m.getGameResults()));
    }

}
