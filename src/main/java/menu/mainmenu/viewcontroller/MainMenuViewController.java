package menu.mainmenu.viewcontroller;

import javafx.fxml.FXML;
import menu.mainmenu.controller.MainMenuController;

/**
 * This class models the main menu view controller.
 */
public class MainMenuViewController {

    private MainMenuController menuController;

    /**
     * Builds a new {@link MainMenuViewController}.
     */
    public MainMenuViewController() {
    }

    /**
     * This method exits the game.
     */
    @FXML
    private void exitGame() {
        this.menuController.exit();
    }

    /**
     * This method creates a new game.
     */
    @FXML
    private void createGame() {
        this.menuController.goNext();
    }

    /**
     * Setter for menuController.
     * 
     * @param controller the {@link menu.mainmenu.controller.MainMenuController}
     */
    public final void setMainMenuController(final MainMenuController controller) {
        this.menuController = controller;
    }

}
