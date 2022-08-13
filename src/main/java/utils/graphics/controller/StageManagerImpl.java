package utils.graphics.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.model.SceneHandlerImpl;
import utils.graphics.view.Gui;
import utils.graphics.view.GuiImpl;

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
        this.gui = new GuiImpl(title);
        this.lastGameController = Optional.empty();
    }

    @Override
    public final void addFXMLScene(final String fxmlUrl, final Class<?> viewControllerClass,
            final GenericController controller) {
        final var currScene = this.gui.loadScene(fxmlUrl, viewControllerClass, controller);
        SceneHandlerImpl.addFXMLScene(this.scenes, currScene);
        this.lastGameController = Optional.ofNullable(SceneHandlerImpl.checkGameController(controller));
    }

    @Override
    public final void addScene(final S scene) {
        SceneHandlerImpl.addScene(this.scenes, scene);
    }

    @Override
    public final S popScene() {
        return SceneHandlerImpl.popScene(this.scenes, this.gui);
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
