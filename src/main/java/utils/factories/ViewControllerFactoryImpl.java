package utils.factories;

/**
 * This class provides static methods to create view controllers.
 */
public final class ViewControllerFactoryImpl {

    private ViewControllerFactoryImpl() {
    }

    /**
     * This method creates a {@link GenericControllerCallback} to be used by
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @param viewControllerClass the class of the view controller
     * @return the {@link GenericControllerCallback} created using the parameter
     */
    public static GenericControllerCallback createViewController(final Class<?> viewControllerClass) {
        return new GenericControllerCallback(viewControllerClass);
    }

}
