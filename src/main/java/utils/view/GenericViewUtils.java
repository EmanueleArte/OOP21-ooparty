package utils.view;

import utils.controller.GenericController;
import utils.graphics.controller.StageManager;

/**
 * The class {@link GenericViewUtils} contains a method useful to create a scene
 * using javafx.
 */
public final class GenericViewUtils {

    private GenericViewUtils() {
    }

    /**
     * This method create a specific scene given the arguments.
     * 
     * @param <S>                 the scenes of the stage
     * @param stageManager        the stage manager of the application
     * @param controller          the controller that act on the scene
     * @param fxmlUrl             the url to the fxml file to open
     */
    public static <S> void createScene(final StageManager<S> stageManager, final GenericController controller, final String fxmlUrl) {
        stageManager.addFXMLScene(fxmlUrl, controller);
    }

}
