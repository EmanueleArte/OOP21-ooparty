package utils.controller;

import utils.view.GenericViewController;

/**
 * This interface models a generic controller.
 */
public interface GenericController {

    /**
     * Setter for the view controller.
     *
     * @param viewController the view controller to use
     * @throws IllegalArgumentException if the parameter is of the wrong type
     */
    void setViewController(GenericViewController viewController) throws IllegalArgumentException;

    /**
     * Getter for the view controller.
     *
     * @return the view controller
     */
    GenericViewController getViewController();

}
