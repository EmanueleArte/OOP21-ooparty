package menu.gamecreationmenu.controller;

import menu.MenuControllerAbstr;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import menu.gamecreationmenu.view.GameCreationMenuView;
import menu.gamecreationmenu.view.GameCreationMenuViewImpl;
import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewController;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl extends MenuControllerAbstr implements GameCreationMenuController {

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
    public final void goNext() {
        this.menuModel.startGame(this.menuViewController.getPlayersNicknames(),
                this.menuViewController.getColorsValues(), this.menuViewController.getTurnsNumber());
    }

    @Override
    public final void exit() {
        this.menuModel.returnToMainMenu();
    }

    @Override
    public final void createMenu() {
        this.menuView = new GameCreationMenuViewImpl<>(this.getStageManager());
        this.menuView.createGameCreationMenu();
        this.menuViewController = this.getStageManager().getGui().getLoader().getController();
        this.menuViewController.setGameCreationMenuController(this);
    }

    @Override
    public final void setActualNumberOfPlayers(final int actualNPlayers) {
        this.menuModel.setActualNPlayers(actualNPlayers);
    }

}
