package utils.graphics.controller;

import java.util.List;
import java.util.Optional;

import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.model.SceneHandler;
import utils.graphics.model.SceneHandlerImpl;
import utils.graphics.view.EmptyGui;
import utils.graphics.view.Gui;
import utils.graphics.view.JavafxGui;
import utils.graphics.view.JavafxGuiImpl;

/**
 * Implementation of {@link StageManager}.
 * 
 * @param <S> the scenes of the stage
 */
public class StageManagerImpl<S> implements StageManager<S> {

    private final SceneHandler<S> sceneHandler;
    private final Gui gui;
    private Optional<MinigameController> lastGameController;

    /**
     * Builds a new {@link StageManagerImpl}.
     * 
     * @param title    the title of the frame
     * @param guiClass the class of the gui
     */
    public StageManagerImpl(final String title, final Class<?> guiClass) {
        this.sceneHandler = new SceneHandlerImpl<>();
        this.lastGameController = Optional.empty();
        this.gui = new JavafxGuiImpl(title, this);
    }

    /**
     * Builds a new {@link StageManagerImpl}.
     * 
     */
    public StageManagerImpl() {
        this.sceneHandler = new SceneHandlerImpl<>();
        this.lastGameController = Optional.empty();
        this.gui = new EmptyGui();
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void addFXMLScene(final String fxmlUrl, final GenericController controller) {
        final var currScene = ((JavafxGui) this.gui).loadScene(fxmlUrl, controller);
        this.addScene((S) currScene);
        this.lastGameController = Optional.ofNullable(this.checkGameController(controller));
    }

    @Override
    public final void addScene(final S scene) {
        this.sceneHandler.addScene(scene);
    }

    @Override
    public final S popScene() {
        var poppedScene = this.sceneHandler.popScene();
        if (gui.mainStagePresence()) {
            gui.setScene(this.getScenes().get(this.sceneHandler.lastSceneIndex()));
        }
        return poppedScene;
    }

    @Override
    public final void run() {
        this.gui.createGui();
    }

    @Override
    public final List<S> getScenes() {
        return this.sceneHandler.getScenes();
    }

    @Override
    public final MinigameController getLastGameController() {
        return this.lastGameController.orElse(null);
    }

    @Override
    public final void setLastGameController(final GenericController controller) {
        this.lastGameController = Optional.ofNullable(this.checkGameController(controller));
    }

    @Override
    public final Gui getGui() {
        return this.gui;
    }

    /**
     * This methods checks if the controller parameter is a minigame controller.
     * 
     * @param controller the controller to check
     * @return the controller casted to {@link MinigameController} if it is a
     *         minigame controller else the already saved controller that can be
     *         null if no minigames have been played
     */
    private MinigameController checkGameController(final GenericController controller) {
        if (controller instanceof MinigameController) {
            return (MinigameController) controller;
        }
        return this.getLastGameController();
    }

}
