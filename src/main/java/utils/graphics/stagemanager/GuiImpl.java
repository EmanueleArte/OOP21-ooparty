package utils.graphics.stagemanager;

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
import utils.GenericController;
import utils.GenericViewController;
import utils.factories.ViewControllerFactoryImpl;

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
    private Optional<Parent> root;

    /**
     * Builds a new {@link GuiImpl}.
     * 
     * @param title the title of the frame
     * @param s     the {@link utils.graphics.stagemanager.StageManager}
     */
    public GuiImpl(final String title, final StageManager<S> s) {
        this.mainStage = Optional.empty();
        this.root = Optional.empty();
        this.frame = new JFrame(title);
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

    @Override
    public final <U> void loadScene(final String fxmlUrl, final Class<?> viewControllerClass, final List<U> players,
            final GenericController controller) {
        Platform.runLater(() -> {
            this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
            this.loader.setControllerFactory(ViewControllerFactoryImpl.createViewController(viewControllerClass));
            try {
                this.root = Optional.ofNullable(this.loader.load());
                this.setScene(new Scene(this.root.get()));
                controller.setViewController(this.loader.getController());
                ((GenericViewController) this.loader.getController()).setController(controller);
            } catch (IOException e1) {
                e1.printStackTrace();
                this.root = Optional.empty();
            }
        });
    }

    @Override
    public final void setScene(final Scene scene) {
        this.mainStage.get().setScene(scene);
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
