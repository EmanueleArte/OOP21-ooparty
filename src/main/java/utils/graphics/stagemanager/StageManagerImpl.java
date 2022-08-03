package utils.graphics.stagemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.Gui;
import utils.graphics.GuiImpl;
import utils.graphics.SceneHandler;

/**
 * Implementation of {@link StageManager}.
 * 
 * @param <S> the scenes of the stage
 */
public class StageManagerImpl<S> implements StageManager<S> {

    private final List<S> scenes;
    private final Gui gui;
    private Optional<MinigameController> lastGameController;

    /**
     * Builds a new {@link StageManagerImpl}.
     * 
     * @param title the title of the frame
     */
    public StageManagerImpl(final String title) {
        this.scenes = new ArrayList<S>();
        this.gui = new GuiImpl(title, this);
        this.lastGameController = Optional.empty();
    }

    @Override
    public final <U> void addFXMLScene(final String fxmlUrl, final Class<?> viewControllerClass,
            final GenericController controller) {
        final var currScene = this.gui.loadScene(fxmlUrl, viewControllerClass, controller);
        SceneHandler.addFXMLScene(this.scenes, currScene);
        this.lastGameController = Optional.ofNullable(SceneHandler.checkGameController(controller));
    }

    @Override
    public final void addScene(final S scene) {
        SceneHandler.addScene(this.scenes, scene);
    }

    @Override
    public final S popScene() {
        System.out.println(scenes);
        return SceneHandler.popScene(this.scenes, this.gui);
    }

    @Override
    public final void run() {
        this.gui.createGui();
    }

    @Override
    public final List<S> getScenes() {
        return this.scenes;
    }

    @Override
    public final MinigameController getLastGameController() {
        return this.lastGameController.orElse(null);
    }

    @Override
    public final Gui getGui() {
        return this.gui;
    }

}
