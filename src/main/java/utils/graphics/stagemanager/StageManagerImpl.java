package utils.graphics.stagemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minigames.common.viewcontroller.MinigameController;
import utils.enums.ControllerType;

/**
 * Implementation of {@link StageManager}.
 * 
 * @param <S> the scenes of the stage
 */
public class StageManagerImpl<S> implements StageManager<S> {

    private final List<S> scenes;
    private final Gui<S> gui;
    private Optional<MinigameController> lastGameController;

    /**
     * Builds a new {@link StageManagerImpl}.
     * 
     * @param title the title of the frame
     */
    public StageManagerImpl(final String title) {
        this.scenes = new ArrayList<S>();
        this.gui = new GuiImpl<>(title, this);
        this.lastGameController = Optional.empty();
    }

    @Override
    public final <U> void addFXMLScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
        this.gui.loadScene(fxmlUrl, c, players);
        this.lastGameController = Optional.ofNullable(SceneHandler.addFXMLScene(this.scenes, this.gui));
    }

    @Override
    public final void addScene(final S scene) {
        SceneHandler.addScene(this.scenes, scene);
    }

    @Override
    public final S popScene() {
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
    public final Gui<S> getGui() {
        return this.gui;
    }

}
