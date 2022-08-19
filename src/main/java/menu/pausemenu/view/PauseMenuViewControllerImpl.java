package menu.pausemenu.view;

import javafx.fxml.FXML;
import menu.common.controller.MenuController;
import utils.controller.GenericController;
import utils.view.GenericViewController;

/**
 * Implementation of {@link GenericViewController}.
 */
public class PauseMenuViewControllerImpl implements GenericViewController {

    private MenuController menuController;

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
        this.menuController.exit();
    }

    /**
     * This method continues the game.
     */
    @FXML
    private void continueGame() {
        this.menuController.goNext();
    }

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

}
