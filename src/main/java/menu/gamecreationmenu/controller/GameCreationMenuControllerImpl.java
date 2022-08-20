package menu.gamecreationmenu.controller;

import menu.common.controller.MenuController;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.view.GameCreationMenuViewController;
import menu.gamecreationmenu.view.GameCreationMenuViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link MenuController}.
 */
public class GameCreationMenuControllerImpl extends GenericControllerAbstr implements MenuController {

    private final GameCreationMenuModel menuModel;
    private GameCreationMenuViewController menuViewController;

    /**
     * Builder for {@link GameCreationMenuControllerImpl}.
     * 
     * @param <S>   the scenes of the stage
     * @param s     the {@link StageManager}
     * @param model the {@link GameCreationMenuModel}
     */
    public <S> GameCreationMenuControllerImpl(final StageManager<S> s, final GameCreationMenuModel model) {
        super(s);
        this.menuModel = model;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) throws IllegalArgumentException {
        if (viewController instanceof GameCreationMenuViewControllerImpl) {
            this.menuViewController = (GameCreationMenuViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException(
                    "The parameter must be an instance of GameCreationMenuViewControllerImpl");
        }
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
        this.getStageManager().popScene();
    }

    @Override
    public final void createMenu() {
        this.getStageManager().getGui().getViewFactory().createGameCreationMenuView(this);
    }

    /**
     * This method sets the actual number of players.
     */
    private void setActualNumberOfPlayers() {
        this.menuModel.setActualNPlayers(this.menuViewController.getActualNumberOfPlayers());
    }

}
