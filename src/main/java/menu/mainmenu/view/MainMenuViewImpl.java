package menu.mainmenu.view;

import menu.mainmenu.viewcontroller.MainMenuViewControllerImpl;
import utils.GenericController;
import utils.GenericViewAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link MainMenuViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
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
