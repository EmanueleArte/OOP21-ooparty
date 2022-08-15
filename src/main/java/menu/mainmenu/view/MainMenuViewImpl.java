package menu.mainmenu.view;

import menu.mainmenu.viewcontroller.MainMenuViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericViewAbstr;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link MainMenuViewImpl}.
     * 
     * @param s the {@link StageManager}
     */
    public MainMenuViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void createScene(final GenericController controller) {
        final String fxmlUrl = "menu/main_menu.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, MainMenuViewControllerImpl.class, controller);
    }

}
