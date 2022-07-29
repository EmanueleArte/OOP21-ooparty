package menu.mainmenu.view;

import menu.MenuView;
import menu.mainmenu.viewcontroller.MainMenuViewControllerImpl;
import utils.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MainMenuView}.
 * 
 * @param <S> the scenes of the stage
 */
public class MainMenuViewImpl<S> implements MenuView<S> {

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
    public final void createMenu(final GenericController controller) {
        final String fxmlUrl = "menu/main_menu.fxml";
        this.stageManager.addFXMLScene(fxmlUrl, MainMenuViewControllerImpl.class, controller);
    }

}
