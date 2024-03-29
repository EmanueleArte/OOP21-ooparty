package utils.factories.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.dice.model.DiceModelNoRepeatImpl;
import game.gamehandler.controller.GameHandlerController;
import game.gamehandler.controller.GameHandlerControllerImpl;
import game.gamehandler.model.GameHandlerModelImpl;
import game.player.Player;
import menu.afterminigamemenu.controller.AfterMinigameMenuController;
import menu.afterminigamemenu.controller.AfterMinigameMenuControllerImpl;
import menu.common.controller.MenuController;
import menu.gamecreationmenu.controller.GameCreationMenuControllerImpl;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import menu.mainmenu.controller.MainMenuControllerImpl;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.pausemenu.controller.PauseMenuControllerImpl;
import menu.powerupmenu.controller.PowerupMenuController;
import menu.powerupmenu.controller.PowerupMenuControllerImpl;
import menu.powerupmenu.model.PowerupMenuModelImpl;
import minigames.common.controller.MinigameController;
import minigames.cutfromtheteam.controller.CutFromTheTeamControllerImpl;
import minigames.cutfromtheteam.model.CutFromTheTeamModelImpl;
import minigames.mastermind.controller.MastermindControllerImpl;
import minigames.mastermind.model.MastermindModelImpl;
import minigames.memo.controller.MemoControllerImpl;
import minigames.memo.model.MemoModelImpl;
import minigames.whoriskswins.controller.WhoRisksWinsControllerImpl;
import minigames.whoriskswins.model.WhoRisksWinsModelImpl;
import minigames.yourethebobomb.controller.YoureTheBobombControllerImpl;
import minigames.yourethebobomb.model.YoureTheBobombModelImpl;
import utils.graphics.controller.StageManager;

public class ControllerFactoryFx<S> implements ControllerFactory {

    private final StageManager<S> stageManager;

    /**
     * Builds a {@link ControllerFactoryFx}.
     *
     * @param stageManager the {@link StageManager}
     */
    public ControllerFactoryFx(final StageManager<S> stageManager) {
        super();
        this.stageManager = stageManager;
    }

    @Override
    public final GameHandlerController createGameHandlerController(final List<Player> players, final int turnsNumber) {
        var diceController = this.createDiceController(false);
        var model = new GameHandlerModelImpl(diceController.getModel(), players, turnsNumber);
        GameHandlerController controller = new GameHandlerControllerImpl(stageManager, diceController, model);
        return controller;
    }

    @Override
    public final MenuController createMainMenuController() {
        var model = new MainMenuModelImpl();
        var controller = new MainMenuControllerImpl(this.stageManager, model);
        return controller;
    }

    @Override
    public final MenuController createGameCreationMenuController() {
        var model = new GameCreationMenuModelImpl();
        var controller = new GameCreationMenuControllerImpl(this.stageManager, model);
        return controller;
    }

    @Override
    public final MenuController createPauseMenuController() {
        var controller = new PauseMenuControllerImpl(this.stageManager);
        return controller;
    }

    @Override
    public final AfterMinigameMenuController createAfterMinigameMenuController() {
        var controller = new AfterMinigameMenuControllerImpl(this.stageManager);
        return controller;
    }

    @Override
    public final MinigameController createMastermindController(final List<Player> players) {
        var diceController = this.createDiceController(true);
        var model = new MastermindModelImpl(players, diceController.getModel());
        var controller = new MastermindControllerImpl(this.stageManager, model, diceController);
        return controller;
    }

    @Override
    public final MinigameController createWhoRisksWinsController(final List<Player> players) {
        var diceController = this.createDiceController(true);
        var model = new WhoRisksWinsModelImpl(players, diceController.getModel());
        var controller = new WhoRisksWinsControllerImpl(this.stageManager, model, diceController);
        return controller;
    }

    @Override
    public final MinigameController createMemoController(final List<Player> players) {
        var diceController = this.createDiceController(true);
        var model = new MemoModelImpl(players, diceController.getModel());
        var controller = new MemoControllerImpl(this.stageManager, model, diceController);
        return controller;
    }

    @Override
    public final MinigameController createYoureTheBobombController(final List<Player> players) {
        var diceController = this.createDiceController(true);
        var model = new YoureTheBobombModelImpl(players, diceController.getModel());
        var controller = new YoureTheBobombControllerImpl(this.stageManager, model, diceController);
        return controller;
    }

    @Override
    public final MinigameController createCutFromTheTeamController(final List<Player> players) {
        var diceController = this.createDiceController(true);
        var model = new CutFromTheTeamModelImpl(players, diceController.getModel());
        var controller = new CutFromTheTeamControllerImpl(this.stageManager, model, diceController);
        return controller;
    }

    @Override
    public final PowerupMenuController createPowerupMenuController(final List<Player> players) {
        var model = new PowerupMenuModelImpl(players);
        var controller = new PowerupMenuControllerImpl(this.stageManager, model);
        return controller;
    }

    @Override
    public final DiceController createDiceController(final boolean noRepeat) {
        DiceModel model;
        if (noRepeat) {
            model = new DiceModelNoRepeatImpl();
        } else {
            model = new DiceModelImpl();
        }
        var controller = new DiceControllerImpl(stageManager, model, noRepeat);
        return controller;
    }

}
