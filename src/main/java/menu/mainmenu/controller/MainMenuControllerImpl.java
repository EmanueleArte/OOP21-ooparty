package menu.mainmenu.controller;

import javafx.scene.Scene;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import menu.mainmenu.viewcontroller.MainMenuViewController;
import utils.graphics.stagemanager.StageManager;

public class MainMenuControllerImpl<S> implements MainMenuController<S> {

    private final MainMenuModel<S> menuModel;
    private final MainMenuViewController menuView;

    public MainMenuControllerImpl(final StageManager<S> s) {
        this.menuModel = new MainMenuModelImpl<>(s);
        final MainMenuView<S> mainMenu = new MainMenuViewImpl<>(s);
        mainMenu.createMainMenu();
    }

    @Override
    public void goNext() {

    }

    @Override
    public void exit() {
        // TODO Auto-generated method stub

    }

}
