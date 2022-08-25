package utils.view;

import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.graphics.view.JavafxGui;

/**
 * 
 * Implementation of {@link ViewLoader}.
 *
 * @param <S> the scenes of the stage
 */
public class ViewLoaderFx<S> implements ViewLoader<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link ViewLoaderFx}.
     *
     * @param s the {@link StageManager}.
     */
    public ViewLoaderFx(final StageManager<S> s) {
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

    @Override
    public final void createMemoView(final GenericController controller) {
        this.createScene(controller, "minigames/memo.fxml");
    }

    @Override
    public final void createYoureTheBobombView(final GenericController controller) {
        this.createScene(controller, "minigames/you_are_the_bobomb.fxml");
    }

    @Override
    public final void createCutFromTheTeamView(final GenericController controller) {
        this.createScene(controller, "minigames/cut_from_the_team.fxml");
    }

    @Override
    public final void createDiceView(final GenericController controller) {
        this.createScene(controller, "game/dice.fxml");
    }

    @Override
    public final void createGameHandlerView(final GenericController controller) {
        this.createScene(controller, "game/game.fxml");
    }

    @Override
    public final void createPowerupMenuView(final GenericController controller) {
        this.createScene(controller, "menu/powerupmenu.fxml");
    }

    @Override
    public final void createMastermindGuideView(final GenericController controller) {
        this.createScene(controller, "minigames/mastermind_guide.fxml");
    }

    @Override
    public final void createWhoRisksWinsGuideView(final GenericController controller) {
        this.createScene(controller, "minigames/who_risks_wins_guide.fxml");
    }

    @Override
    public final void createMemoGuideView(final GenericController controller) {
        this.createScene(controller, "minigames/memo_guide.fxml");
    }

    @Override
    public final void createYoureTheBobombGuideView(final GenericController controller) {
        this.createScene(controller, "minigames/you_are_the_bobomb_guide.fxml");
    }

    @Override
    public final void createCutFromTheTeamGuideView(final GenericController controller) {
        this.createScene(controller, "minigames/cut_from_the_team_guide.fxml");
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
