package utils.graphics;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Optional<JFXPanel> mainStage;
    private FXMLLoader loader;
    private final JFrame frame;
    private final ControllerSelector<S> cSelector;
    private Parent root = null;

    /**
     * Builds a new {@link GuiImpl}.
     * 
     * @param title the title of the frame
     * @param s     the {@link utils.graphics.StageManager}
     */
    public GuiImpl(final String title, final StageManager<S> s) {
        this.mainStage = Optional.empty();
        this.frame = new JFrame(title);
        this.cSelector = new ControllerSelectorImpl<>(s);
    }

    @Override
    public final void createGui() {
        this.mainStage = Optional.of(new JFXPanel());
        this.frame.add(this.mainStage.get());
        this.frame.pack();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setMinimumSize(new Dimension(GuiImpl.MIN_WIDTH, GuiImpl.MIN_HEIGHT));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final <U> void loadScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
        Platform.runLater(() -> {
            this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
            this.loader.setControllerFactory(this.cSelector.selectControllerCallback(c, players));
            try {
                this.root = loader.load();
                this.setScene((S) new Scene(this.root));
            } catch (IOException e1) {
                e1.printStackTrace();
                this.root = null;
            }
        });
    }

    @Override
    public final void setScene(final S scene) {
        this.mainStage.get().setScene((Scene) scene);
    }

    @Override
    public final FXMLLoader getLoader() {
        return this.loader;
    }

    @Override
    public final Scene getStageScene() {
        if (this.mainStage.isEmpty()) {
            return null;
        }
        Optional<Scene> scene = Optional.empty();
        while (scene.isEmpty()) {
            scene = Optional.ofNullable(this.mainStage.get().getScene());
        }
        return scene.get();
    }

}
