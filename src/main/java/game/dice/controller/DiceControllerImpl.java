package game.dice.controller;

import java.util.Optional;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.dice.model.DiceModelNoRepeatImpl;
import game.dice.view.DiceViewControllerImpl;
import utils.view.GenericViewUtils;
import game.player.Player;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of the {@link DiceController} interface.
 */
public class DiceControllerImpl extends GenericControllerAbstr implements DiceController {
    private final DiceModel model;
    private DiceViewControllerImpl viewController;
    private final boolean playoff;

    /**
     * Constructor for this class.
     * 
     * @param <S>
     * @param s 
     * @param noRepeat {@link Boolean} representing whether the dice must avoid repetition or not
     */
    public <S> DiceControllerImpl(final StageManager<S> s, final boolean noRepeat) {
        super(s);
        if (noRepeat) {
            this.model = new DiceModelNoRepeatImpl();
        } else {
            this.model = new DiceModelImpl();
        }
        this.playoff = noRepeat;
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) {
        if (viewController instanceof DiceViewControllerImpl) {
            this.viewController = (DiceViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceViewControllerImpl");
        }
    }

    @Override
    public final int rollDice(final Player p) {
        int result = this.model.rollDice();
        GenericViewUtils.createScene(this.getStageManager(), this, "game/dice.fxml");
        if (this.playoff) {
            this.viewController.initialize(result, p.getColor(), "Playoff!");
        } else {
            this.viewController.initialize(result, p.getColor(), "Roll the Dice!");
        }
        return result;
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.model.getLastResult();
    }

    @Override
    public final int getTotal() {
        return this.model.getTotal();
    }

    @Override
    public final void reset() {
        this.model.reset();
    }

    @Override
    public final void returnToGame() {
        this.getStageManager().popScene();
    }

}
