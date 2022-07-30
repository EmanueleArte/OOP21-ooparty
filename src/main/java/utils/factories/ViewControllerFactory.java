package utils.factories;

/**
 * This interface provides methods to create view controllers.
 */
public interface ViewControllerFactory {

    /**
     * This method creates a {@link GenericControllerCallback} to be used by
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @param viewControllerClass the class of the view controller
     * @return the {@link GenericControllerCallback} created using the parameter
     */
    GenericControllerCallback createViewController(Class<?> viewControllerClass);

}
