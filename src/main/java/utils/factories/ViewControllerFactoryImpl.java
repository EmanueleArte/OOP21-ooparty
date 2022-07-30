package utils.factories;

/**
 * Implementation of {@link ViewControllerFactory}.
 */
public class ViewControllerFactoryImpl implements ViewControllerFactory {

    /**
     * Builds a new {@link ViewControllerFactoryImpl}.
     */
    public ViewControllerFactoryImpl() {
    }

    @Override
    public final GenericControllerCallback createViewController(final Class<?> viewControllerClass) {
        return new GenericControllerCallback(viewControllerClass);
    }

}
