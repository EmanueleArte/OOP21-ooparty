package menu.common.view;

import menu.common.controller.MenuController;
import utils.controller.GenericController;
import utils.view.GenericViewController;

/**
 * This abstract class models a simple menu view controller. Implementation of
 * {@link GenericViewController}.
 */
public abstract class SimpleMenuViewControllerAbstr implements GenericViewController {

    private MenuController menuController;

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

    /**
     * Getter for the controller.
     * 
     * @return the menu controller used
     */
    protected final MenuController getController() {
        return this.menuController;
    }

}
