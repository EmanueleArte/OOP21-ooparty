package utils.controller;

import utils.view.GenericViewController;

/**
 * This interface models a generic controller.
 */
public interface GenericController {

    /**
     * Setter for the view controller.
     * 
     * @param <C>            the view controller type
     * @param viewController the view controller
     * @throws IllegalArgumentException if the parameter is of the wrong type
     */
    <C> void setViewController(C viewController) throws IllegalArgumentException;

    /**
     * Getter for the view controller.
     * 
     * @return the view controller
     */
    GenericViewController getViewController();

}
