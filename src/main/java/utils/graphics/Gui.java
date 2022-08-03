package utils.graphics;

import java.util.Optional;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import utils.controller.GenericController;

/**
 * This interface models the javafx gui.
 */
public interface Gui {

    /**
     * This method starts the javafx gui.
     * 
     */
    void createGui();

    /**
     * This method loads an FXML file.
     * 
     * @param fxmlUrl             the url of the fxml file to load
     * @param viewControllerClass the type of the view controller
     * @param controller          the controller to be used
     */
    Scene loadScene(String fxmlUrl, Class<?> viewControllerClass, GenericController controller);

    /**
     * This method shows the actual scene.
     * 
     * @param scene the {@link Scene} to be shown
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
     * @throws InterruptedException 
     */
    Scene getStageScene() throws InterruptedException;

    /**
     * Getter for the main stage.
     * 
     * @return the {@link javafx.embed.swing.JFXPanel} that is the main stage
     */
    Optional<JFXPanel> getMainStage();

}
