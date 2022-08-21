package game.dice.controller;

import game.player.Player;

import java.util.Iterator;

import game.dice.model.DiceModel;
import game.dice.view.DiceViewController;
import utils.Pair;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of the {@link DiceController} interface.
 */
public class DiceControllerImpl extends GenericControllerAbstr implements DiceController {
    private final DiceModel model;
    private DiceViewController viewController;
    private Iterator<Pair<Player, Integer>> results;
    private final boolean playoff;
    private boolean end;

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
        this.end = false;
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
        this.end = false;
        this.results = this.model.getResults().iterator();
        if (this.results.hasNext()) {
            this.nextScene();
        }
    }

    @Override
    public final void nextStep() {
        if (this.end) {
            this.getStageManager().popScene();
            this.end = false;
            if (this.results.hasNext()) {
                this.nextScene();
            }
        } else {
            this.viewController.jumpToDice();
            this.end = true;
        }
    }

    private void nextScene() {
        if (!this.results.hasNext()) {
            throw new RuntimeException("No more dice rolls to show");
        }
        final Pair<Player, Integer> r = this.results.next();
        this.getStageManager().getGui().getViewFactory().createDiceView(this);
        if (this.playoff) {
            this.viewController.initialize(r.getY(), r.getX().getColor(), "Playoff!");
        } else {
            this.viewController.initialize(r.getY(), r.getX().getColor(), "Roll the Dice!");
        }
    }

    @Override
    public final DiceModel getModel() {
        return this.model;
    }
}
