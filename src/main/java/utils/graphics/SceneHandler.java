package utils.graphics;

import java.util.List;
import java.util.Optional;

import javafx.scene.Scene;
import minigames.common.controller.MinigameController;
import utils.controller.GenericController;

/**
 * This static class models the actions that handle the scenes.
 */
public final class SceneHandler {

    private SceneHandler() {
    }

    /**
     * This method adds an scene loaded from an FXML file to the scenes list.
     * 
     * @param <S>    the scenes of the stage
     * @param scenes the scenes list
     * @param gui    the gui of the game
     */
    @SuppressWarnings("unchecked")
    public static <S> void addFXMLScene(final List<S> scenes, final Gui gui) throws IllegalArgumentException {
        if (scenes.get(0) instanceof Scene) {
            final Optional<Scene> scene = Optional.ofNullable(gui.getStageScene((Scene) scenes.get(SceneHandler.lastSceneIndex(scenes))));
            if (scene.isPresent()) {
                scenes.add((S) scene.get());
                gui.setScene(scene.get());
            }
        } else {
            throw new IllegalArgumentException("The elements of scenes list are not of type Scene.");
        }
    }

    /**
     * This method adds an existing scene to the scenes list.
     * 
     * @param <S>    the scenes of the stage
     * @param scenes the scenes list
     * @param scene  the scene to add
     */
    public static <S> void addScene(final List<S> scenes, final S scene) {
        Optional<S> s = Optional.ofNullable(scene);
        if (s.isPresent()) {
            scenes.add(scene);
        }
    }

    /**
     * 
     * @param <S>    the scenes of the stage
     * @param scenes the scenes list
     * @param gui    the gui of the game
     * @return the last added scene or null if the scenes list is empty.
     */
    public static <S> S popScene(final List<S> scenes, final Gui gui) {
        if (scenes.isEmpty()) {
            return null;
        }
        var poppedScene = scenes.remove(SceneHandler.lastSceneIndex(scenes));
        if (gui.getStageScene((Scene) scenes.get(SceneHandler.lastSceneIndex(scenes))) != null) {
            gui.setScene((Scene) scenes.get(SceneHandler.lastSceneIndex(scenes)));
        }
        return poppedScene;
    }

    /**
     * This method calculates the index of the last added scene.
     * 
     * @param <S>    the scenes
     * @param scenes the scenes list
     * @return the index of the last added scene
     */
    public static <S> int lastSceneIndex(final List<S> scenes) {
        return scenes.size() - 1;
    }

    /**
     * This methods checks if the controller parameter is a minigame controller.
     * 
     * @param controller the controller to check
     * @return the controller casted to {@link MinigameController} if it is a
     *         minigame controller else null
     */
    public static MinigameController checkGameController(final GenericController controller) {
        if (controller instanceof MinigameController) {
            return (MinigameController) controller;
        }
        return null;
    }

}
