package utils.graphics.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import utils.controller.GenericController;

/**
 * This interface models the javafx gui.
 */
public interface FxmlGui extends Gui {

    /**
     * This method loads a scene from FXML file.
     * 
     * @param fxmlUrl             the url of the fxml file to load
     * @param controller          the controller to be used
     * @return the scene loaded
     */
    Scene loadScene(String fxmlUrl, GenericController controller);

    /**
     * This method shows the actual scene.
     * 
     * @param scene the {@link Scene} to be shown
     * @throws RuntimeException if the stage is not set
     */
    void setScene(Scene scene);

    /**
     * Getter for the {@link FXMLLoader}.
     * 
     * @return the last loader used
     */
    FXMLLoader getLoader();

    /**
     * Getter for the {@link javafx.embed.swing.JFXPanel} current scene.
     * 
     * @return the main stage {@link Scene}
     * @throws RuntimeException if the stage is not set
     */
    Scene getStageScene() throws RuntimeException;

}
