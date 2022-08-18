package menu.afterminigamemenu.view;

import menu.MenuController;
import utils.controller.GenericController;

public class AfterMinigameMenuViewControllerImpl implements AfterMinigameMenuViewController {

    private MenuController menuController;

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

}
