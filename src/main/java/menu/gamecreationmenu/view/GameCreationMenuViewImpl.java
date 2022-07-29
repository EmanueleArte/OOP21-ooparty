package menu.gamecreationmenu.view;

import menu.MenuView;
import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewControllerImpl;
import utils.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MenuView}.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuViewImpl<S> implements MenuView<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link GameCreationMenuViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public GameCreationMenuViewImpl(final StageManager<S> s) {
        this.stageManager = s;
    }

    @Override
    public final void createMenu(final GenericController controller) {
        final String fxmlUrl = "menu/creation_menu.fxml";
        this.stageManager.addFXMLScene(fxmlUrl, GameCreationMenuViewControllerImpl.class, controller);
    }

}
