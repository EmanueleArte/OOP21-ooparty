package menu.mainmenu.controller;

import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import menu.mainmenu.viewcontroller.MainMenuViewController;
import utils.graphics.stagemanager.StageManager;

public class MainMenuControllerImpl implements MainMenuController {

    private final MainMenuModel<?> menuModel;
    private final MainMenuViewController menuViewController;

    public <S> MainMenuControllerImpl(final StageManager<S> s) {
        this.menuModel = new MainMenuModelImpl<>(s);
        final MainMenuView<S> mainMenu = new MainMenuViewImpl<>(s);
        mainMenu.createMainMenu();
        this.menuViewController = s.getGui().getLoader().getController();
        this.menuViewController.setMainMenuController(this);
    }

    @Override
    public final void goNext() {
        this.menuModel.gameCreationMenu();
    }

    @Override
    public final void exit() {
        this.menuModel.exit();
    }

}
