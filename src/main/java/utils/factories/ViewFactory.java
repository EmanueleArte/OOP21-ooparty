package utils.factories;

import utils.controller.GenericController;

/**
 * This interface models a factory for the views.
 *
 * @param <S> the scenes of the stages
 */
public interface ViewFactory<S> {

    /**
     * This method creates a main menu view.
     * 
     * @param controller the controller to be used
     */
    void createMainMenuView(GenericController controller);

    /**
     * This method creates a game creation menu view.
     * 
     * @param controller the controller to be used
     */
    void createGameCreationMenuView(GenericController controller);

    /**
     * This method creates an after minigame menu.
     * 
     * @param controller the controller to be used 
     */
    void createAfterMinigameMenu(GenericController controller);

    /**
     * This method creates a pause menu view.
     * 
     * @param controller the controller to be used
     */
    void createPauseMenuView(GenericController controller);

    /**
     * This method creates a mastermind view.
     * 
     * @param controller the controller to be used
     */
    void createMastermindView(GenericController controller);

    /**
     * This method creates a who risks wins view.
     * 
     * @param controller the controller to be used
     */
    void createWhoRisksWinsView(GenericController controller);

}
