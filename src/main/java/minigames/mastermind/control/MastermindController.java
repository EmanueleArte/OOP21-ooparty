package minigames.mastermind.control;

/**
 * This interface models the mastermind controller.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MastermindController<S, U> {

    /**
     * This method starts the mastermind minigame.
     */
    void startGame();

    /**
     * This method tries a guess.
     */
    void tryGuess();

    /**
     * This method clears the notice.
     */
    void clearNotice();

}
