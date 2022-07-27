package menu.gamecreationmenu.controller;

import menu.MenuController;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import menu.gamecreationmenu.view.GameCreationMenuView;
import menu.gamecreationmenu.view.GameCreationMenuViewImpl;
import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewController;
import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewControllerImpl;
import utils.GenericControllerAbstr;
import utils.GenericViewController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of {@link MenuController}.
 */
public class GameCreationMenuControllerImpl extends GenericControllerAbstr implements MenuController {

    private final GameCreationMenuModel<?> menuModel;
    private GameCreationMenuViewController menuViewController;

    /**
     * Builder for {@link GameCreationMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> GameCreationMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.menuModel = new GameCreationMenuModelImpl<>(s);
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        this.menuViewController = (GameCreationMenuViewControllerImpl) viewController;
    }

    @Override
    public final GenericViewController getViewController() {
        return this.menuViewController;
    }

    @Override
    public final void goNext() {
        this.setActualNumberOfPlayers();
        if (!this.menuModel.startGame(this.menuViewController.getPlayersNicknames(),
                this.menuViewController.getColorsValues(), this.menuViewController.getTurnsNumber())) {
            this.menuViewController.showError();
        }
    }

    @Override
    public final void exit() {
        this.menuModel.returnToMainMenu();
    }

    @Override
    public final void createMenu() {
        final GameCreationMenuView<?> menuView = new GameCreationMenuViewImpl<>(this.getStageManager());
        menuView.createGameCreationMenu(this);
    }

    /**
     * This method sets the actual number of players.
     */
    private void setActualNumberOfPlayers() {
        this.menuModel.setActualNPlayers(this.menuViewController.getActualNumberOfPlayers());
    }

}
