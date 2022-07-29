package minigames.mastermind.view;

import minigames.mastermind.viewcontroller.MastermindViewControllerImpl;
import utils.GenericController;
import utils.GenericViewAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MastermindViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link MastermindViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MastermindViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void createScene(final GenericController controller) {
        final String fxmlUrl = "minigames/mastermind.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, MastermindViewControllerImpl.class, controller);
    }

}
