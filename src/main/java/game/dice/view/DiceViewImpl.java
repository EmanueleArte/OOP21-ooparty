package game.dice.view;

import game.dice.viewcontroller.DiceViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericViewAbstr;

public class DiceViewImpl<S> extends GenericViewAbstr {

    public DiceViewImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public void createScene(final GenericController controller) {
        final String fxmlUrl = "game/dice.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, DiceViewControllerImpl.class, controller);
    }

}
