package minigames.memo.view;

import minigames.common.viewcontroller.MinigameGuideViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericViewAbstr;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MemoGuideViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link WhoRisksWinsGuideViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MemoGuideViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public void createScene(final GenericController controller) {
        final String fxmlUrl = "minigames/memo_guide.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, MinigameGuideViewControllerImpl.class, controller);
    }

}
