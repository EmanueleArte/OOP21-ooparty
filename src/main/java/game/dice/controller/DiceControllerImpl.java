package game.dice.controller;

import java.util.Optional;

import game.dice.model.DiceModel;
import game.dice.view.DiceViewController;
import game.player.Player;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class DiceControllerImpl extends GenericControllerAbstr implements DiceController {
    private final DiceModel model;
    private DiceViewController viewController;
    private final boolean noRepeat;

    public <S> DiceControllerImpl(final StageManager<S> s, final DiceModel model, final boolean noRepeat) {
        super(s);
        this.model = model;
        this.noRepeat = noRepeat;
    }

    @Override
    public final void start(final Player p) {
        this.getStageManager().getGui().getViewFactory().createDiceView(this);
        if (this.noRepeat) {
            this.viewController.initialize(p.getColor(), "Playoff!");
        } else {
            this.viewController.initialize(p.getColor(), "Roll the Dice!");
        }
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) {
        if (viewController instanceof DiceViewController) {
            this.viewController = (DiceViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceViewController");
        }
    }

    @Override
    public final void returnToGame() {
        this.getStageManager().popScene();
    }

    @Override
    public final void rollDice() {
        this.model.rollDice();
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.model.getLastResult();
    }

    @Override
    public final void reset() {
        this.model.reset();
    }

    @Override
    public final Optional<Integer> getTotal() {
        return this.model.getTotal();
    }

    @Override
    public final DiceModel getModel() {
        return this.model;
    }
}
