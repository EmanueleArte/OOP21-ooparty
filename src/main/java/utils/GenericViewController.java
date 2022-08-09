package utils;

import utils.controller.GenericController;

/**
 * This interface models a generic view controller.
 */
public interface GenericViewController {

    /**
     * Setter for the controller.
     * 
     * @param controller the controller to be used
     */
    void setController(GenericController controller);

}
