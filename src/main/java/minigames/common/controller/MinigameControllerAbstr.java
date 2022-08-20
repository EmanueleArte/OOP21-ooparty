package minigames.common.controller;

import game.dice.controller.DiceController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of {@link MinigameController}.
 */
public abstract class MinigameControllerAbstr extends GenericControllerAbstr implements MinigameController {

    private final DiceController dice;

    /**
     * Builds a {@link MinigameControllerAbstr}.
     * 
     * @param <S>  the scenes of the stage
     * @param s    the {@link StageManager}
     * @param dice the {@link DiceController}
     */
    public <S> MinigameControllerAbstr(final StageManager<S> s, final DiceController dice) {
        super(s);
        this.dice = dice;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void closeGame() {
        this.getStageManager().popScene();
    }

    /**
     * Getter for the dice controller.
     * 
     * @return the {@link DiceController}
     */
    protected DiceController getDice() {
        return this.dice;
    }

}
