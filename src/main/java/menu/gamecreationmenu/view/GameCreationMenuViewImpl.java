package menu.gamecreationmenu.view;

import utils.enums.ControllerType;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuView}.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuViewImpl<S> implements GameCreationMenuView<S> {

    private final StageManager<S> stageManager;

    public GameCreationMenuViewImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final void createGameCreationMenu() {
        final String fxmlUrl = "menu/creation_menu.fxml";
        this.stageManager.addScene(fxmlUrl, ControllerType.GAME_CREATION_MENU, null);
    }

}
