package game.dice.controller;

import java.util.Optional;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.dice.model.DiceModelNoRepeatImpl;
import game.dice.view.DiceViewImpl;
import game.dice.viewcontroller.DiceViewControllerImpl;
import game.player.Player;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericView;

public class DiceControllerImpl extends GenericControllerAbstr implements DiceController {
    private final DiceModel<?> model;
    private DiceViewControllerImpl viewController;

    public <S, P> DiceControllerImpl(final StageManager<S> s, final boolean noRepeat) {
        super(s);
        if (noRepeat) {
            this.model = new DiceModelNoRepeatImpl<P>(s);
        } else {
            this.model = new DiceModelImpl<P>(s);
        }
    }

    @Override
    public final void start(final Player p) {
        final GenericView<?> view = new DiceViewImpl<>(this.getStageManager());
        view.createScene(this);
        this.viewController.initialize(p.getColor());
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        if (viewController instanceof DiceViewControllerImpl) {
            this.viewController = (DiceViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceViewControllerImpl");
        }
    }

    @Override
    public final void returnToGame() {
        this.model.returnToGame();
    }

    @Override
    public final void rollDice() {
        this.model.rollDice();
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.model.getLastResult();
    }

}
