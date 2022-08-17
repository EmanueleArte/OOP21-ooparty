package minigames.whoriskswins.view;

import minigames.common.view.MinigameViewController;

/**
 * Extension of {@link MinigameViewController}.
 */
public interface WhoRisksWinsViewController extends MinigameViewController {

    /**
     * This method shows the results of the turn.
     * 
     * @param score the score of the player
     */
    void showTurnResults(int score);

}
