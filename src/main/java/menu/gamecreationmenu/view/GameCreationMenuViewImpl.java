package menu.gamecreationmenu.view;

import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericViewAbstr;

/**
 * Extension of {@link GenericViewAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuViewImpl<S> extends GenericViewAbstr<S> {

    /**
     * Builds a new {@link GameCreationMenuViewImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public GameCreationMenuViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void createScene(final GenericController controller) {
        final String fxmlUrl = "menu/creation_menu.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, GameCreationMenuViewControllerImpl.class, controller);
    }

}
