package menu.mainmenu.view;

import utils.enums.ControllerType;
import utils.graphics.StageManager;

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
     * @param s the {@link utils.graphics.StageManager}
     */
    public MainMenuViewImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final void createMainMenu() {
        final String fxmlUrl = "menu/main_menu.fxml";
        this.stageManager.addFXMLScene(fxmlUrl, ControllerType.MAIN_MENU, null);
    }

}
