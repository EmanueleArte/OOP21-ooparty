package menu.mainmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuController}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuControllerImpl<S> implements MainMenuController<S> {

    private final MainMenuModel<S> menuModel;
    @FXML
    private Button exitButton;
    @FXML
    private Button createGameButton;

    public MainMenuControllerImpl(final StageManager<S> s) {
        super();
        this.menuModel = new MainMenuModelImpl<>(s);
    }

    @Override
    public final void exitGame() {
        this.menuModel.exit();
    }

    @Override
    public final void createGame() {
        this.menuModel.gameCreationMenu();
    }

}
