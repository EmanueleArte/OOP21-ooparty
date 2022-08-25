package menu.mainmenu.view;

import javafx.fxml.FXML;
import menu.common.view.SimpleMenuViewControllerAbstr;

/**
 * Extension of {@link SimpleMenuViewControllerAbstr}.
 */
public class MainMenuViewControllerImpl extends SimpleMenuViewControllerAbstr {

    /**
     * Builds a new {@link MainMenuViewControllerImpl}.
     */
    public MainMenuViewControllerImpl() {
    }

    /**
     * This method exits the game.
     */
    @FXML
    private void exitGame() {
        this.getController().exit();
    }

    /**
     * This method creates a new game.
     */
    @FXML
    private void createGame() {
        this.getController().goNext();
    }

}
