package minigames.common.model;

import java.util.List;
import java.util.Map;

import game.common.model.GameModel;
import game.player.Player;

/**
 * This interface models a minigame model.
 */
public interface MinigameModel extends GameModel {

    /**
     * This method returns the results of the minigame that are necessary for points
     * assignment, etc...
     * 
     * @return a list of players ordered by their classification in the minigame
     *         with no draws
     */
    List<Player> getGameResults();

    /**
     * This method associates a player to his score.
     * 
     * @param player the current {@link game.player.Player}
     * @param score  the score of the player at the minigame
     */
    void scoreMapper(Player player, Integer score);

    /**
     * Getter for the score.
     * 
     * @return the score of a player
     */
    int getScore();

    /**
     * Getter for playersClassification.
     * 
     * @return a map with players as keys and their score as values
     */
    Map<Player, Integer> getPlayersClassification();

}
