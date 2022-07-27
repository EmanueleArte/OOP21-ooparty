package minigames.mastermind.viewcontroller;

import minigames.common.viewcontroller.MinigameViewController;

public interface MastermindViewController extends MinigameViewController {

    /**
     * This method shows the attempt done if it is valid.
     * 
     * @param attemptDone the attempt string, it is empty if the attempt is invalid
     */
    void showAttemptDone(String attemptDone);

    /**
     * This method shows the results of the turn.
     */
    void showTurnResults();

}
