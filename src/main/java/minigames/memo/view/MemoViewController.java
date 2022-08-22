package minigames.memo.view;

import java.util.List;

import minigames.common.view.MinigameViewController;

/**
 * This interface models the minigame {@code memo}'s controller. This interface
 * is a specialization of {@link MinigameViewController}.
 */
public interface MemoViewController extends MinigameViewController {

    /**
     * This method acts as the constructor for the class
     * {@link MemoViewControllerImpl}. It hides all the excessive cards and maps the
     * buttons to their value.
     *
     * @param cards the number of buttons to keep.
     */
    void start(List<Integer> cards);

}
