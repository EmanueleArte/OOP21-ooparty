package minigames.common.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;

/**
 * Extension of {@link GenericController}.
 */
public interface MinigameController extends GenericController {

    /**
     * This method returns the results of the minigame.
     * 
     * @return the list of players ordered by their score in the minigame (from
     *         higher to lower)
     */
    List<Player> getGameResults();

    /**
     * This method starts the minigame routine, opens a guide if exists.
     */
    void startGame();

    /**
     * This method starts a new turn.
     * 
     * @return true if there is another player that has to play
     */
    boolean nextTurn();

}
