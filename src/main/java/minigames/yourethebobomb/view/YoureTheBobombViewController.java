package minigames.yourethebobomb.view;

import java.util.List;

import minigames.common.view.MinigameViewController;

/**
 * This interface models the minigame {@code cut from the team}'s view. This
 * interface is a specialization of {@link MinigameViewController}.
 */
public interface YoureTheBobombViewController extends MinigameViewController {

    /**
     * This method acts as the constructor for the class
     * {@link YoureTheBobombViewControllerImpl}. It maps the buttons to their value.
     *
     * @param tiles the number of buttons to keep.
     */
    void start(List<Integer> tiles);

    /**
     * This method put the name of the player in the tile he choose.
     * 
     * @param nickname   the nickname of the player to add.
     * @param tileNumber the number associated with the tile chosen.
     */
    void putPlayerIntoTile(String nickname, int tileNumber);

    /**
     * This method enables the button that closes the game.
     */
    void enableCloseButton();

}
