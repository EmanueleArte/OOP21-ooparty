package game.gamehandler.controller;

import java.util.List;

import game.gamehandler.model.GameHandlerModel;
import game.gamehandler.model.GameHandlerModelImpl;
import game.gamehandler.view.GameHandlerViewImpl;
import game.gamehandler.viewcontroller.GameHandlerViewControllerImpl;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.GenericViewController;
import utils.graphics.stagemanager.StageManager;

public class GameHandlerControllerImpl extends GenericControllerAbstr implements GenericController {

    private GameHandlerViewControllerImpl viewController;
    private GameHandlerModel model;

    public <S, U> GameHandlerControllerImpl(StageManager<S> s, List<U> players) {
        super(s);
        model = new GameHandlerModelImpl(s, players, null);
    }

    public void start() {
        GameHandlerViewImpl view = new GameHandlerViewImpl(this.getStageManager());
        //view.startMinigame(this.model.getPlayers(), this);
    }

    @Override
    public <C> void setViewController(C viewController) {
        this.viewController = (GameHandlerViewControllerImpl) viewController;
    }

    @Override
    public GenericViewController getViewController() {
        return this.viewController;
    }

    public int nextStep() {
        //return this.model.nextStep();
        return 0;
    }

}
