package game.dice.controller;

import java.util.ArrayList;
import java.util.List;
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

public class DiceControllerImpl extends GenericControllerAbstr implements DiceController {
    private final DiceModel model;
    private DiceViewControllerImpl viewController;
    private final boolean playoff;
    private final List<Integer> resultsList;

    public <S> DiceControllerImpl(final StageManager<S> s, final boolean noRepeat) {
        super(s);
        if (noRepeat) {
            this.model = new DiceModelNoRepeatImpl();
        } else {
            this.model = new DiceModelImpl();
        }
        this.playoff = noRepeat;
        this.resultsList = new ArrayList<>();
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
    public final void returnToGame() {
        this.getStageManager().popScene();
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
        this.resultsList.add(result);
        return result;
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.model.getLastResult();
    }

    @Override
    public final void reset() {
        this.resultsList.clear();
        this.model.reset();
    }

    @Override
    public final int getTotal() {
        return this.resultsList.stream().reduce(0, Integer::sum);
    }

}
