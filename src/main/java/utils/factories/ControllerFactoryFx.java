package utils.factories;

import java.util.List;

import game.gamehandler.controller.GameHandlerControllerImpl;
import game.gamehandler.model.GameHandlerModelImpl;
import game.map.GameMapImpl;
import game.player.Player;
import menu.common.controller.MenuController;
import menu.mainmenu.controller.MainMenuControllerImpl;
import menu.mainmenu.model.MainMenuModelImpl;
import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;

public class ControllerFactoryFx<S> implements ControllerFactory {

    private final StageManager<S> stageManager;

    public ControllerFactoryFx(final StageManager<S> stageManager) {
        super();
        this.stageManager = stageManager;
    }

    @Override
    public GenericController createGameHandlerController(final List<Player> players, final int turnsNumber) {
        var controllerDice = this.createDiceController();
        var model = new GameHandlerModelImpl<S>(stageManager, players, turnsNumber, null);
        var controller = new GameHandlerControllerImpl<S>(stageManager, players, turnsNumber, null);
        return controller;
    }

    @Override
    public MenuController createMainMenuController() {
        var model = new MainMenuModelImpl<S>(this.stageManager);
        var controller = new MainMenuControllerImpl(stageManager);
        return controller;
    }

    @Override
    public MenuController createGameCreationMenuController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MenuController createPauseMenuController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MenuController createAfterMinigameController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MinigameController createMastermindController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MinigameController createWhoRisksWinsController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MinigameController createMemoController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GenericController createDiceController() {
        // TODO Auto-generated method stub
        return null;
    }

}
