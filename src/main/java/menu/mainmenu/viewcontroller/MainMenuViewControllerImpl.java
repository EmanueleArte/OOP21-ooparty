package menu.mainmenu.viewcontroller;

import javafx.fxml.FXML;
import menu.MenuController;
import utils.GenericController;
import utils.GenericViewController;

/**
 * Implementation of {@link GenericViewController}.
 */
public class MainMenuViewControllerImpl implements GenericViewController {

    private MenuController menuController;

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
        this.menuController.exit();
    }

    /**
     * This method creates a new game.
     */
    @FXML
    private void createGame() {
        this.menuController.goNext();
    }

    @Override
    public final void setController(final GenericController controller) {
        this.menuController = (MenuController) controller;
    }

}
