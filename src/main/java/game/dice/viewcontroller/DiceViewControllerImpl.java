package game.dice.viewcontroller;

import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import javafx.fxml.FXML;
import menu.MenuController;
import utils.GenericViewController;
import utils.controller.GenericController;

public class DiceViewControllerImpl implements GenericViewController {
    private DiceController controller;

    @Override
    public void setController(final GenericController controller) {
        if (controller instanceof DiceControllerImpl) {
            this.controller = (DiceController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceController");
        }
    }

    @FXML
    public void nextStep() {
        this.controller.returnToGame();
    }

}
