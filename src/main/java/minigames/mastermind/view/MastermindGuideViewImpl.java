package minigames.mastermind.view;

import minigames.mastermind.viewcontroller.MastermindGuideViewControllerImpl;
import minigames.mastermind.viewcontroller.MastermindViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericViewAbstr;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MastermindGuideViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link MastermindViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MastermindGuideViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public void createScene(final GenericController controller) {
        final String fxmlUrl = "minigames/mastermind_guide.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, MastermindGuideViewControllerImpl.class, controller);
    }

}
