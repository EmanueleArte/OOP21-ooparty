package game.gamehandler.view;

import java.util.List;

import minigames.common.viewcontroller.MinigameViewControllerAbstr;
import utils.controller.GenericController;
import utils.view.GenericViewAbstr;
import utils.graphics.stagemanager.StageManager;

public class GameHandlerViewImpl<S> extends GenericViewAbstr {

    public GameHandlerViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public void createScene(final GenericController controller) {
        // TODO Auto-generated method stub

    }

}
