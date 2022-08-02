package utils.graphics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import utils.controller.GenericController;

/**
 * This interface models the javafx gui.
 *
 * @param <S> the scenes of the stage
 */
public interface Gui<S> {

    /**
     * This method starts the javafx gui.
     * 
     */
    void createGui();

    /**
     * This method loads an FXML file.
     * 
     * @param <U>                 the player
     * @param fxmlUrl             the url of the fxml file to load
     * @param viewControllerClass the type of the view controller
     * @param controller          the controller to be used
     */
    <U> void loadScene(String fxmlUrl, Class<?> viewControllerClass, GenericController controller);

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
     * @param lastScene the last scene in saved
     * @return the main stage {@link Scene}
     */
    Scene getStageScene(Scene lastScene);

}
