package menu.powerupmenu.view;

import javafx.fxml.FXML;
import menu.powerupmenu.controller.PowerupMenuController;
import menu.powerupmenu.controller.PowerupMenuControllerImpl;
import utils.view.GenericViewController;
import utils.controller.GenericController;

public class PowerupMenuViewControllerImpl implements GenericViewController {

    private PowerupMenuController controller;

    @Override
    public final void setController(final GenericController controller) {
        if (controller instanceof PowerupMenuControllerImpl) {
            this.controller = (PowerupMenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PowerupMenuController");
        }
    }

    @FXML
    public final void close() {
        this.controller.returnToGame();
    }
}
