package utils.graphics.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import minigames.common.controller.MinigameController;
import utils.controller.GenericController;

/**
 * Implementation of {@link SceneHandler}.
 * 
 * @param <S> the scenes of the stage
 */
public class SceneHandlerImpl<S> implements SceneHandler<S> {

    private final List<S> scenes;

    /**
     * Builds a new {@link SceneHandlerImpl}.
     */
    public SceneHandlerImpl() {
        this.scenes = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void addFXMLScene(final Scene scene) throws IllegalArgumentException {
        var test = (S) new Scene(new Label(""));
        if (!this.scenes.isEmpty()) {
            test = this.scenes.get(0);
        }
        if (test instanceof Scene) {
            this.addScene((S) scene);
        } else {
            throw new IllegalArgumentException("The elements of scenes list are not of type Scene.");
        }
    }

    @Override
    public final void addScene(final S scene) {
        Optional<S> s = Optional.ofNullable(scene);
        if (s.isPresent()) {
            scenes.add(scene);
        }
    }

    @Override
    public final S popScene() {
        if (this.scenes.isEmpty()) {
            return null;
        }
        var poppedScene = this.scenes.remove(this.lastSceneIndex());
        if (gui.getMainStage().isPresent()) {
            gui.setScene((Scene) this.scenes.get(this.lastSceneIndex()));
        }
        return poppedScene;
    }

    @Override
    public final int lastSceneIndex() throws RuntimeException {
        final int nScenes = this.scenes.size();
        if (nScenes == 0) {
            throw new RuntimeException("Scenes list is empty.");
        }
        return nScenes - 1;
    }

    @Override
    public final MinigameController checkGameController(final GenericController controller) {
        if (controller instanceof MinigameController) {
            return (MinigameController) controller;
        }
        return null;
    }

}
