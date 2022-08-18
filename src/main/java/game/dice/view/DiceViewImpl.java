package game.dice.view;

import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewAbstr;

public class DiceViewImpl<S> extends GenericViewAbstr<S> {

    public DiceViewImpl(final StageManager<S> stageManager) {
        super(stageManager);
    }

    @Override
    public final void createScene(final GenericController controller) {
        final String fxmlUrl = "game/dice.fxml";
        this.getStageManager().addFXMLScene(fxmlUrl, controller);
    }

}
