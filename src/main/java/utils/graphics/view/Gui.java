package utils.graphics.view;

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

}
