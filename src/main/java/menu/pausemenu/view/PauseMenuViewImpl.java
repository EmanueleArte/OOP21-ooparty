package menu.pausemenu.view;

import menu.pausemenu.viewcontroller.PauseMenuViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericViewAbstr;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class PauseMenuViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link PauseMenuViewImpl}.
     * 
     * @param s the {@link StageManager}
     */
    public PauseMenuViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void createScene(final GenericController controller) {
        final String fxmlUrl = "menu/pause_menu.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, PauseMenuViewControllerImpl.class, controller);
    }

}
