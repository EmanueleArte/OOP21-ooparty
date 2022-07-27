package minigames.mastermind.view;

import java.util.List;

import minigames.common.view.MinigameViewAbstr;
import utils.GenericController;
import utils.enums.ViewControllerType;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link minigames.common.view.MinigameViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindViewImpl<S, U> extends MinigameViewAbstr<S, U> {

    /**
     * Builds a new {@link MastermindViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MastermindViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void startMinigame(final List<U> players, final GenericController controller) {
        final String fxmlUrl = "minigames/mastermind.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, ViewControllerType.MASTERMIND, players, controller);
    }

}
