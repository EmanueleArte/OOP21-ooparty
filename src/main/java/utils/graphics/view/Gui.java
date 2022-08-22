package utils.graphics.view;

import utils.view.ViewLoader;

/**
 * This interface models a generic gui.
 */
public interface Gui {

    /**
     * This method starts the gui.
     */
    void createGui();

    /**
     * This method checks if a main stage is present.
     * 
     * @return true if a main stage is present else false
     */
    boolean mainStagePresence();

    /**
     * Getter for the view factory.
     * 
     * @return the view factory
     */
    ViewLoader<?> getViewFactory();

    /**
     * This method shows the actual scene.
     * 
     * @param <S>   the scenes of the stage
     * @param scene the scene to be shown
     * @throws RuntimeException if the stage is not set
     */
    <S> void setScene(S scene) throws RuntimeException;

}
