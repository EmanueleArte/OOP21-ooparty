package minigames.mastermind.view;

import java.util.List;
import minigames.common.view.MinigameViewAbstr;
import utils.enums.ControllerType;
import utils.graphics.StageManager;

/**
 * Extension of {@link minigames.common.view.MinigameViewAbstr}.
 */
public class MastermindViewImpl<S, U> extends MinigameViewAbstr<S, U> {

	public MastermindViewImpl(StageManager<S> s) {
		super(s);
	}

	@Override
	public void startMinigame(List<U> players) {
		final String fxmlUrl = "minigames/mastermind.fxml";
		this.stageManager.addScene(fxmlUrl, ControllerType.MASTERMIND, players);
	}

	

}
