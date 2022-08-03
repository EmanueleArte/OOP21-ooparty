package game.dice.controller;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.dice.view.DiceViewImpl;
import game.dice.viewcontroller.DiceViewControllerImpl;
import game.player.Player;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericView;

public class DiceControllerImpl<S, P> extends GenericControllerAbstr implements DiceController<S> {
    private final DiceModel<P> model;
    private DiceViewControllerImpl viewController;

    public DiceControllerImpl(final StageManager<S> s) {
        super(s);
        this.model = new DiceModelImpl(s);
    }

    @Override
    public void start(final Player p) {
        final GenericView<?> view = new DiceViewImpl<>(this.getStageManager());
        view.createScene(this);
        this.viewController.initialize(p.getColor());
    }

    @Override
    public GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public <C> void setViewController(final C viewController) {
        if (viewController instanceof DiceViewControllerImpl) {
            this.viewController = (DiceViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceViewControllerImpl");
        }
    }

    @Override
    public void returnToGame() {
        this.model.returnToGame();
    }

    @Override
    public void rollDice() {
        this.model.rollDice();
    }

    @Override
    public int getResult() {
        return this.model.getResult();
    }

}
