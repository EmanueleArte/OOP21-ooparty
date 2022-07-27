package menu.mainmenu.view;

import utils.GenericController;
import utils.enums.ViewControllerType;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MainMenuView}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuViewImpl<S> implements MainMenuView<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link MainMenuViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MainMenuViewImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final void createMainMenu(final GenericController controller) {
        final String fxmlUrl = "menu/main_menu.fxml";
        this.stageManager.addFXMLScene(fxmlUrl, ViewControllerType.MAIN_MENU, null, controller);
    }

}
