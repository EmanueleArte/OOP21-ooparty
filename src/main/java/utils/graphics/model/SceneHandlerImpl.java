package utils.graphics.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.view.Gui;

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
    public final void addFXMLScene(final List<S> scenes, final Scene scene) throws IllegalArgumentException {
        S test = (S) new Scene(new Label(""));
        if (test instanceof Scene) {
            this.addScene(scenes, (S) scene);
        } else {
            throw new IllegalArgumentException("The elements of scenes list are not of type Scene.");
        }
    }

    @Override
    public final void addScene(final List<S> scenes, final S scene) {
        Optional<S> s = Optional.ofNullable(scene);
        if (s.isPresent()) {
            scenes.add(scene);
        }
    }

    @Override
    public final S popScene(final List<S> scenes, final Gui gui) {
        if (scenes.isEmpty()) {
            return null;
        }
        var poppedScene = scenes.remove(this.lastSceneIndex(scenes));
        if (gui.getMainStage().isPresent()) {
            gui.setScene((Scene) scenes.get(this.lastSceneIndex(scenes)));
        }
        return poppedScene;
    }

    @Override
    public final int lastSceneIndex(final List<S> scenes) throws RuntimeException {
        final int nScenes = scenes.size();
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
