package utils.graphics;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import minigames.common.control.MinigameController;
import utils.enums.ControllerType;
import utils.factories.ControllerSelector;
import utils.factories.ControllerSelectorImpl;

/**
 * Implementation of {@link Gui}.
 *
 * @param <S> the scenes of the stage
 */
public class GuiImpl<S> extends JFrame implements Gui<S> {

    private static final long serialVersionUID = -4895173910811030481L;
    /**
     * Minimum window width.
     */
    public static final int MIN_WIDTH = 1000;
    /**
     * Minimum window height.
     */
    public static final int MIN_HEIGHT = 730;
    private JFXPanel mainStage;
    private FXMLLoader loader;
    private final JFrame frame;
    private final ControllerSelector<S> cSelector;

    /**
     * Builds a new {@link GuiImpl}.
     * 
     * @param title the title of the frame
     * @param s     the {@link utils.graphics.StageManager}
     */
    public GuiImpl(final String title, final StageManager<S> s) {
        this.frame = new JFrame(title);
        this.cSelector = new ControllerSelectorImpl<>(s);
    }

    @Override
    public final void createGui() {
        this.mainStage = new JFXPanel();
        this.frame.add(this.mainStage);
        this.frame.pack();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setMinimumSize(new Dimension(GuiImpl.MIN_WIDTH, GuiImpl.MIN_HEIGHT));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @Override
    public final <U> S loadScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
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
        return null;
    }

    @Override
    public final void setScene(final S scene) {
        this.mainStage.setScene((Scene) scene);
    }

}
