package minigames.mastermind.view;

import java.util.List;
import minigames.common.view.MinigameViewAbstr;
import utils.enums.ControllerType;
import utils.graphics.StageManager;

/**
 * Extension of {@link minigames.common.view.MinigameViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindViewImpl<S, U> extends MinigameViewAbstr<S, U> {

    public MastermindViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void startMinigame(final List<U> players) {
        final String fxmlUrl = "minigames/mastermind.fxml";
        this.getStageManager().addScene(fxmlUrl, ControllerType.MASTERMIND, players);
    }

}
