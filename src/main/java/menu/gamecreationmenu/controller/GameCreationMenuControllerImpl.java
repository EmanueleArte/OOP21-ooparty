package menu.gamecreationmenu.controller;

import menu.MenuControllerAbstr;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import menu.gamecreationmenu.view.GameCreationMenuView;
import menu.gamecreationmenu.view.GameCreationMenuViewImpl;
import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link MenuControllerAbstr}.
 */
public class GameCreationMenuControllerImpl extends MenuControllerAbstr {

    private final GameCreationMenuModel<?> menuModel;
    private GameCreationMenuView<?> menuView;
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
        this.menuViewController = (GameCreationMenuViewController) viewController;
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
        this.menuView = new GameCreationMenuViewImpl<>(this.getStageManager());
        this.menuView.createGameCreationMenu(this);
        this.menuViewController.setGameCreationMenuController(this);
    }

    /**
     * This method sets the actual number of players.
     */
    private void setActualNumberOfPlayers() {
        this.menuModel.setActualNPlayers(this.menuViewController.getActualNumberOfPlayers());
    }

}
