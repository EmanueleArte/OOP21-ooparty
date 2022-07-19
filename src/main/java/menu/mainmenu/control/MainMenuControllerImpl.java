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

    public MainMenuControllerImpl(final StageManager<S> s) {
        super();
        this.menuModel = new MainMenuModelImpl<>(s);
    }

    @FXML
    @Override
    public final void exitGame() {
        this.menuModel.exit();
    }

    @FXML
    @Override
    public final void createGame() {
        this.menuModel.gameCreationMenu();
    }

}
