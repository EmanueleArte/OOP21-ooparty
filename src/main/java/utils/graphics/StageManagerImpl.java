package utils.graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import minigames.common.viewcontroller.MinigameController;
import utils.enums.ControllerType;

/**
 * Implementation of {@link StageManager} and extension of {@link JFrame}.
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

    @SuppressWarnings("unchecked")
    @Override
    public final <U> void addFXMLScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
        this.gui.loadScene(fxmlUrl, c, players);
        final S scene = (S) this.gui.getStageScene();
        if (scene != null) {
            this.scenes.add(scene);
            this.gui.setScene(scene);
            var controller = this.gui.getLoader().getController();
            if (controller.getClass().getInterfaces().toString().contains("MinigameController")) {
                this.lastGameController = Optional.ofNullable((MinigameController) controller);
            }
        }
    }

    @Override
    public final void addScene(final S scene) {
        if (scene != null) {
            this.scenes.add(scene);
        }
    }

    @Override
    public final S popScene() {
        var poppedScene = this.scenes.remove(this.lastSceneIndex());
        if (this.gui.getStageScene() != null) {
            this.gui.setScene(this.scenes.get(this.lastSceneIndex()));
        }
        return poppedScene;
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

    /**
     * This method calculates the index of the last added scene.
     * 
     * @return the index of the last added scene
     */
    private int lastSceneIndex() {
        return this.scenes.size() - 1;
    }

}
