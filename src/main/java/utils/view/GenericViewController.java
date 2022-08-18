package utils.view;

import utils.controller.GenericController;

/**
 * This interface models a generic view controller.
 */
public interface GenericViewController {

    /**
     * Setter for the controller.
     * 
     * @param controller the controller to be used
     * @throws IllegalArgumentException if the parameter is of the wrong type
     */
    void setController(GenericController controller) throws IllegalArgumentException;

}
