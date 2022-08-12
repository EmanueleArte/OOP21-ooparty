package utils.view;

import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * The class {@link GenericViewUtils} contains a method useful to create a scene using javafx.
 */
public final class GenericViewUtils {

    private GenericViewUtils() {
    }

    /**
     * This method create a specific scene given the arguments.
     * @param stageManager - the stage manager of the application
     * @param controller - the controller that act on the scene
     * @param viewControllerClass - the class of the viewcontroller that handle the scene
     * @param fxmlUrl - the url to the fxml file to open
     */
    public static void createScene(final StageManager stageManager, final GenericController controller, final Class<?> viewControllerClass, final String fxmlUrl) {
        stageManager.addFXMLScene(fxmlUrl, viewControllerClass, controller);
    }

}
