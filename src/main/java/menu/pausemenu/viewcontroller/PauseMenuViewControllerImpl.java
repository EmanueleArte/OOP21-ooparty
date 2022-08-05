package menu.pausemenu.viewcontroller;

import menu.MenuController;
import utils.GenericViewController;
import utils.controller.GenericController;

/**
 * Implementation of {@link GenericViewController}.
 */
public class PauseMenuViewControllerImpl implements GenericViewController {

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
