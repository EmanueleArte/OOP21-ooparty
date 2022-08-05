package game.gamehandler.view;

import game.gamehandler.viewcontroller.GameHandlerViewControllerImpl;
import utils.controller.GenericController;
import utils.view.GenericViewAbstr;
import utils.graphics.stagemanager.StageManager;

public class GameHandlerViewImpl<S> extends GenericViewAbstr<S> {

    public GameHandlerViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void createScene(final GenericController controller) {
        final String fxmlUrl = "game/game.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, GameHandlerViewControllerImpl.class, controller);
    }

}
