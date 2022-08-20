package menu.mainmenu.model;

import menu.common.controller.MenuController;
import menu.gamecreationmenu.controller.GameCreationMenuControllerImpl;

/**
 * Implementation of {@link MainMenuModel}.
 */
public class MainMenuModelImpl implements MainMenuModel {

    /**
     * Builds a new {@link MainMenuModelImpl}.
     */
    public MainMenuModelImpl() {
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
