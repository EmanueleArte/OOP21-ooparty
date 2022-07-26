package menu.mainmenu.viewcontroller;

import javafx.fxml.FXML;
import menu.MenuController;

/**
 * This class models the main menu view controller.
 */
public class MainMenuViewController {

    private MenuController menuController;

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
     * @param controller the {@link menu.MenuController}
     */
    public final void setMainMenuController(final MenuController controller) {
        this.menuController = controller;
    }

}
