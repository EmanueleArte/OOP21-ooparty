package menu.gamecreationmenu.view;

import menu.MenuController;
import utils.enums.ViewControllerType;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link GameCreationMenuView}.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuViewImpl<S> implements GameCreationMenuView<S> {

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
    public final void createGameCreationMenu() {
        final String fxmlUrl = "menu/creation_menu.fxml";
        this.stageManager.addFXMLScene(fxmlUrl, ViewControllerType.GAME_CREATION_MENU, null);
    }

}
