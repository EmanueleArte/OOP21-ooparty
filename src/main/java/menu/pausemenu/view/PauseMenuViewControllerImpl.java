package menu.pausemenu.view;

import javafx.fxml.FXML;
import menu.common.view.SimpleMenuViewControllerAbstr;

/**
 * Extension of {@link SimpleMenuViewControllerAbstr}.
 */
public class PauseMenuViewControllerImpl extends SimpleMenuViewControllerAbstr {

    /**
     * Builds a new {@link PauseMenuViewControllerImpl}.
     */
    public PauseMenuViewControllerImpl() {
    }

    /**
     * This method returns to the main menu.
     */
    @FXML
    private void returnMainMenu() {
        this.getController().exit();
    }

    /**
     * This method continues the game.
     */
    @FXML
    private void continueGame() {
        this.getController().goNext();
    }

}
