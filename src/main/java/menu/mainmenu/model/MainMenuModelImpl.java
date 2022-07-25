package menu.mainmenu.model;

import menu.gamecreationmenu.view.GameCreationMenuView;
import menu.gamecreationmenu.view.GameCreationMenuViewImpl;
import utils.graphics.StageManagerController;

/**
 * Implementation of {@link MainMenuModel}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuModelImpl<S> implements MainMenuModel<S> {

    private final StageManagerController<S> stageManager;

    /**
     * Builds a new {@link MainMenuModelImpl}.
     * 
     * @param s the {@link utils.graphics.StageManagerController}
     */
    public MainMenuModelImpl(final StageManagerController<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final void exit() {
        System.exit(0);
    }

    @Override
    public final void gameCreationMenu() {
        final GameCreationMenuView<S> creationMenu = new GameCreationMenuViewImpl<>(this.stageManager);
        creationMenu.createGameCreationMenu();
    }

}
