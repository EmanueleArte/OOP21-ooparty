package minigames.mastermind.control;

import minigames.common.control.MinigameController;

/**
 * This interface models the mastermind controller.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MastermindController<S, U> extends MinigameController {

    /**
     * This method tries a guess.
     */
    void tryGuess();

    /**
     * This method clears the notice.
     */
    void clearNotice();

    /**
     * This method starts the next player's turn.
     */
    void startNextTurn();

}
