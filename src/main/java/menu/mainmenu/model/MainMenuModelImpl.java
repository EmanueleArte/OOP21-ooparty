package menu.mainmenu.model;

import menu.common.controller.MenuController;
import menu.gamecreationmenu.controller.GameCreationMenuControllerImpl;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link MainMenuModel}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuModelImpl<S> implements MainMenuModel<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link MainMenuModelImpl}.
     * 
     * @param s the {@link StageManager}
     */
    public MainMenuModelImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final void exit() {
        System.exit(0);
    }

    @Override
    public final void gameCreationMenu() {
        final MenuController gameCreationMenuContr = new GameCreationMenuControllerImpl(this.stageManager);
        gameCreationMenuContr.createMenu();
    }

}
