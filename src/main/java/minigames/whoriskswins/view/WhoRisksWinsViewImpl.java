package minigames.whoriskswins.view;

import minigames.whoriskswins.viewcontroller.WhoRisksWinsViewControllerImpl;
import utils.GenericController;
import utils.GenericViewAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link utils.GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class WhoRisksWinsViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link WhoRisksWinsViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public WhoRisksWinsViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void crateScene(final GenericController controller) {
        final String fxmlUrl = "minigames/who_risks_wins.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, WhoRisksWinsViewControllerImpl.class, controller);
    }

}
