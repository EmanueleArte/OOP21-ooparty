package utils.factories;

import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.graphics.view.JavafxGui;

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
     * @param s the {@link StageManager}.
     */
    public FxmlViewFactoryImpl(final StageManager<S> s) {
        this.stageManager = s;
    }

    @Override
    public final void createMainMenuView(final GenericController controller) {
        this.createScene(controller, "menu/main_menu.fxml");
    }

    public final void createAfterMinigameMenu(final GenericController controller) {
        this.createScene(controller, "menu/after_minigame_menu.fxml");
    }

    @Override
    public final void createGameCreationMenuView(final GenericController controller) {
        this.createScene(controller, "menu/creation_menu.fxml");
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
        final var currScene = ((JavafxGui) this.stageManager.getGui()).loadScene(fxmlUrl, controller);
        this.stageManager.setLastGameController(controller);
        this.stageManager.addScene((S) currScene);
    }

}
