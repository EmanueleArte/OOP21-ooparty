package minigames.whoriskswins.view;

import minigames.common.view.MinigameViewAbstr;
import minigames.mastermind.viewcontroller.WhoRisksWinsViewControllerImpl;
import utils.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link minigames.common.view.MinigameViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class WhoRisksWinsViewImpl<S> extends MinigameViewAbstr<S> {

    /**
     * Builds a new {@link WhoRisksWinsViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public WhoRisksWinsViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void startMinigame(final GenericController controller) {
        final String fxmlUrl = "minigames/who_risks_wins.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, WhoRisksWinsViewControllerImpl.class, controller);
    }

}
