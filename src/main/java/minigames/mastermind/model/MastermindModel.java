package minigames.mastermind.model;

/**
 * This interface models the mastermind model.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MastermindModel<S, U> {

    /**
     * Getter for win.
     * 
     * @return true if the current player has guessed the 4-digit number
     */
    boolean getWin();

    /**
     * Getter for lose.
     * 
     * @return true if the current player hasn't guessed the 4-digit number and the
     *         attempts are ended
     */
    boolean getLose();

}
