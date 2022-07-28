package minigames.mastermind.view;

import java.util.List;

import minigames.common.view.MinigameViewAbstr;
import minigames.mastermind.controller.MastermindControllerImpl;
import utils.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link minigames.common.view.MinigameViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MastermindViewImpl<S> extends MinigameViewAbstr<S> {

    /**
     * Builds a new {@link MastermindViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MastermindViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void startMinigame(final List<?> players, final GenericController controller) {
        final String fxmlUrl = "minigames/mastermind.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, MastermindControllerImpl.class, players, controller);
    }

}
