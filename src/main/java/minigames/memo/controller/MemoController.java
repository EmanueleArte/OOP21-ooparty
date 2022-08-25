package minigames.memo.controller;

import minigames.common.controller.MinigameController;

/**
 * This interface models the minigame {@code memo}'s controller. This interface
 * is a specialization of {@link MinigameController}.
 */
public interface MemoController extends MinigameController {

    /**
     * This method updates the view with the name of the current player.
     */
    void updateCurrentPlayerLabel();

    /**
     * This method picks a card.
     *
     * @param cardValue the value of the card.
     */
    void pickCard(int cardValue);

    /**
     * This methods tells whether the game has ended.
     *
     * @return {@code true} if the game has ended, {@code false} otherwise.
     */
    boolean isOver();

}
