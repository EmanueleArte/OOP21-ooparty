package game.dice.controller;

import java.util.Optional;

import game.dice.model.DiceModel;
import game.dice.view.DiceViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of the {@link DiceController} interface.
 */
public class DiceControllerImpl extends GenericControllerAbstr implements DiceController {
    private final DiceModel model;
    private DiceViewController viewController;
    private final boolean playoff;

    /**
     * Constructor for this class.
     * 
     * @param <S>
     * @param s
     * @param noRepeat {@link Boolean} representing whether the dice must avoid
     *                 repetition or not
     */
    public <S> DiceControllerImpl(final StageManager<S> s, final DiceModel model, final boolean noRepeat) {
        super(s);
        this.model = model;
        this.playoff = noRepeat;
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
    public final void start() {
        System.out.println(this.model.getResults());
        this.model.getResults().forEach(r -> {
            this.getStageManager().getGui().getViewFactory().createDiceView(this);
            if (this.playoff) {
                this.viewController.initialize(r.getY(), r.getX().getColor(), "Playoff!");
            } else {
                this.viewController.initialize(r.getY(), r.getX().getColor(), "Roll the Dice!");
            }
        });
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

    @Override
    public final DiceModel getModel() {
        return this.model;
    }
}
