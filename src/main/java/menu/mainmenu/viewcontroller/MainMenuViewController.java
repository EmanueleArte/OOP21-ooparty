package menu.mainmenu.viewcontroller;

import javafx.fxml.FXML;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import utils.graphics.StageManager;

/**
 * This class models the main menu view controller.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuViewController<S> {

    private final MainMenuModel<S> menuModel;

    /**
     * Builds a new {@link MainMenuViewController}.
     * 
     * @param s the {@link utils.graphics.StageManager}
     */
    public MainMenuViewController(final StageManager<S> s) {
        super();
        this.menuModel = new MainMenuModelImpl<>(s);
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
