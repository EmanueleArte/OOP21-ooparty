package utils;

/**
 * This interface models a generic controller.
 */
public interface GenericController {

    /**
     * Setter for the view controller.
     * 
     * @param <C>            the view controller type
     * @param viewController the view controller
     */
    <C> void setViewController(C viewController);

}
