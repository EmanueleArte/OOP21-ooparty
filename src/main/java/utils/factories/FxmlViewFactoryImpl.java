package utils.factories;

import utils.controller.GenericController;
import utils.graphics.controller.StageManager;

/**
 * 
 * Implementation of {@link ViewFactory}.
 *
 * @param <S> the scenes of the stage
 */
public class FxmlViewFactoryImpl<S> implements ViewFactory<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link FxmlViewFactoryImpl}.
     * 
     * @param stageManager the {@link StageManager}.
     */
    public FxmlViewFactoryImpl(final StageManager<S> stageManager) {
        this.stageManager = stageManager;
    }

    @Override
    public final void createMainMenuView(final GenericController controller) {
        this.createScene(controller, "menu/main_menu.fxml");
    }

    @Override
    public final void createGameCreationMenu(final GenericController controller) {
        this.createScene(controller, "manu/creation_menu.fxml");
    }

    @Override
    public final void createPauseMenuView(final GenericController controller) {
        this.createScene(controller, "menu/pause_menu.fxml");
    }

    @Override
    public final void createMastermindView(final GenericController controller) {
        this.createScene(controller, "minigames/mastermind.fxml");
    }

    @Override
    public final void createWhoRisksWinsView(final GenericController controller) {
        this.createScene(controller, "minigames/who_risks_wins.fxml");
    }

    /**
     * This method creates a specific scene given the arguments and adds it to the
     * scene list.
     * 
     * @param controller the controller that act on the scene
     * @param fxmlUrl    the url to the fxml file to open
     */
    @SuppressWarnings("unchecked")
    private void createScene(final GenericController controller, final String fxmlUrl) {
        final var currScene = this.stageManager.getGui().loadScene(fxmlUrl, controller);
        this.stageManager.setLastGameController(controller);
        this.stageManager.addScene((S) currScene);
    }

}
