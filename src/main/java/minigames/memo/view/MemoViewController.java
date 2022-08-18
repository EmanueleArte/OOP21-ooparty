package minigames.memo.view;

import minigames.common.view.MinigameViewController;

/**
 * This interface models the minigame {@code memo}'s controller. This interface is a
 * specialization of {@link MinigameViewController}.
 */
public interface MemoViewController extends MinigameViewController {

    int pickCard();

    void delete(int firstCard, int secondCard);

}
