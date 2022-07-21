package utils.graphics;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import minigames.common.control.MinigameController;
import utils.enums.ControllerType;

/**
 * Implementation of {@link StageManager} and extension of {@link JFrame}.
 * 
 * @param <S> the scenes of the stage
 */
public class StageManagerImpl<S> extends JFrame implements StageManager<S> {

    private static final long serialVersionUID = -2502020530541111808L;
    /**
     * Minimum window width.
     */
    public static final int MIN_WIDTH = 1000;
    /**
     * Minimum window height.
     */
    public static final int MIN_HEIGHT = 730;
    private final List<S> scenes;
    private final Gui<S> gui;
    private MinigameController lastGameController;

    public StageManagerImpl(final String title) {
        this.scenes = new ArrayList<S>();
        this.gui = new GuiImpl<>(title, this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final <U> void addScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
        this.gui.loadScene(fxmlUrl, c, players);
        final S scene = (S) this.gui.getStageScene();
        if (scene != null) {
            this.scenes.add(scene);
            this.gui.setScene(scene);
            var controller = this.gui.getLoader().getController();
            if (controller.getClass().getInterfaces().toString().contains("MinigameController")) {
                this.lastGameController = (MinigameController) controller;
            }
        }
    }

    @Override
    public final S popScene() {
        var poppedScene = this.scenes.remove(this.lastSceneIndex());
        this.gui.setScene(this.scenes.get(this.lastSceneIndex()));
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
    public final MinigameController getLastController() {
        return this.lastGameController;
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
