package minigames.cutfromtheteam.view;

import java.util.List;

import minigames.common.view.MinigameViewController;

/**
 * This interface models the minigame {@code cut from the team}'s view. This
 * interface is a specialization of {@link MinigameViewController}.
 */
public interface CutFromTheTeamViewController extends MinigameViewController {

    /**
     * This method acts as the constructor for the class
     * {@link CutFromTheTeamViewControllerImpl}. It maps the buttons to their value.
     *
     * @param ropes the number of buttons to keep.
     */
    void start(List<Boolean> ropes);

    /**
     * This method enables the button that closes the game.
     */
    void enableCloseButton();

}
