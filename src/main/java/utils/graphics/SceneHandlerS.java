package utils.graphics;

import java.util.List;
import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.view.Gui;

/**
 * This static class models the actions that handle the scenes.
 */
public final class SceneHandlerS {

    private SceneHandlerS() {
    }

    /**
     * This method adds an scene loaded from an FXML file to the scenes list.
     * 
     * @param <S>    the scenes of the stage
     * @param scenes the scenes list
     * @param scene  the scene to add to the list
     */
    @SuppressWarnings("unchecked")
    public static <S> void addFXMLScene(final List<S> scenes, final Scene scene) throws IllegalArgumentException {
        S test = (S) new Scene(new Label(""));
        if (test instanceof Scene) {
            SceneHandlerS.addScene(scenes, (S) scene);
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
        var poppedScene = scenes.remove(SceneHandlerS.lastSceneIndex(scenes));
        if (gui.getMainStage().isPresent()) {
            gui.setScene((Scene) scenes.get(SceneHandlerS.lastSceneIndex(scenes)));
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
    public static <S> int lastSceneIndex(final List<S> scenes) throws RuntimeException {
        final int nScenes = scenes.size();
        if (nScenes == 0) {
            throw new RuntimeException("Scenes list is empty.");
        }
        return nScenes - 1;
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
