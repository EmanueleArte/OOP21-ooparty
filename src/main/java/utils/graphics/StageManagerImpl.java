package utils.graphics;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Callback;
import minigames.common.control.MinigameController;
import utils.enums.ControllerType;
import utils.factories.ControllerFactory;
import utils.factories.ControllerFactoryImpl;

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
    private JFXPanel mainStage;
    private FXMLLoader loader;
    private final JFrame frame;
    private final ControllerFactory<S> controlFactory;
    private MinigameController lastGameController;

    public StageManagerImpl(final String title) {
        this.scenes = new ArrayList<S>();
        this.frame = new JFrame(title);
        this.controlFactory = new ControllerFactoryImpl<>(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final <U> void addScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
        Platform.runLater(() -> {
            Parent root = null;
            this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
            this.loader.setControllerFactory(this.controllerCallback(c, players));
            try {
                root = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (root != null) {
                this.scenes.add((S) new Scene(root));
                this.setScene();
                var controller = this.loader.getController();
                if (controller.getClass().getInterfaces().toString().contains("MinigameController")) {
                    this.lastGameController = (MinigameController) controller;
                }
            }
        });
    }

    @Override
    public final S popScene() {
        var poppedScene = this.scenes.remove(this.lastSceneIndex());
        this.setScene();
        return poppedScene;
    }

    @Override
    public final void run() {
        this.mainStage = new JFXPanel();
        this.frame.add(this.mainStage);
        this.frame.pack();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setMinimumSize(new Dimension(StageManagerImpl.MIN_WIDTH, StageManagerImpl.MIN_HEIGHT));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
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
     * This method shows the actual scene.
     */
    private void setScene() {
        this.mainStage.setScene((Scene) this.scenes.get(this.lastSceneIndex()));
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
