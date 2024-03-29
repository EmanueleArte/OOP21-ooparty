package utils.view;

import utils.controller.GenericController;

/**
 * This interface models a factory for the views.
 *
 * @param <S> the scenes of the stages
 */
public interface ViewLoader<S> {

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
     * This method creates a 'Mastermind' view.
     *
     * @param controller the controller to be used
     */
    void createMastermindView(GenericController controller);

    /**
     * This method creates a 'Who Risks Wins' view.
     *
     * @param controller the controller to be used
     */
    void createWhoRisksWinsView(GenericController controller);

    /**
     * This method creates a 'Memo' view.
     *
     * @param controller the controller to be used
     */
    void createMemoView(GenericController controller);

    /**
     * This method created a 'You're the Bob-omb' view.
     *
     * @param controller the controller to be used
     */
    void createYoureTheBobombView(GenericController controller);

    /**
     * This method creates a 'Cut From the Team' view.
     *
     * @param controller the controller to be used
     */
    void createCutFromTheTeamView(GenericController controller);

    /**
     * This method creates a dice view.
     *
     * @param controller the controller to be used
     */
    void createDiceView(GenericController controller);

    /**
     * This method creates a game handler view.
     *
     * @param controller the controller to be used
     */
    void createGameHandlerView(GenericController controller);

    /**
     * This method created a 'Mastermind' guide view.
     *
     * @param controller the controller to be used
     */
    void createMastermindGuideView(GenericController controller);

    /**
     * This method created a 'Who Risks Wins' guide view.
     *
     * @param controller the controller to be used
     */
    void createWhoRisksWinsGuideView(GenericController controller);

    /**
     * This method created a 'Memo' guide view.
     *
     * @param controller the controller to be used
     */
    void createMemoGuideView(GenericController controller);

    /**
     * This method created a 'You're the Bob-omb' guide view.
     *
     * @param controller the controller to be used
     */
    void createYoureTheBobombGuideView(GenericController controller);

    /**
     * This method created a 'Cut From the Team' guide view.
     *
     * @param controller the controller to be used
     */
    void createCutFromTheTeamGuideView(GenericController controller);

    /**
     * This method created a power-up menu view.
     *
     * @param controller the controller to be used
     */
    void createPowerupMenuView(GenericController controller);

}
