package menu.mainmenu.viewcontroller;

import javafx.fxml.FXML;
import menu.mainmenu.controller.MainMenuController;

/**
 * This class models the main menu view controller.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuViewController<S> {

    private MainMenuController<S> menuController;

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
        this.menuModel.exit();
    }

    /**
     * This method creates a new game.
     */
    @FXML
    private void createGame() {
        this.menuModel.gameCreationMenu();
    }

}
