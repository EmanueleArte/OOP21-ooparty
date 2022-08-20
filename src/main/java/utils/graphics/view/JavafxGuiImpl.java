package utils.graphics.view;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Optional;

import javax.swing.JFrame;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import utils.controller.GenericController;
import utils.factories.ViewFactory;
import utils.factories.FxmlViewFactoryImpl;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of {@link JavafxGui}.
 */
public class JavafxGuiImpl extends JFrame implements JavafxGui {

    private static final long serialVersionUID = -4895173910811030481L;
    /**
     * Minimum window width.
     */
    public static final int MIN_WIDTH = 1280;
    /**
     * Minimum window height.
     */
    public static final int MIN_HEIGHT = 800;
    private Optional<JFXPanel> mainStage;
    private FXMLLoader loader;
    private final JFrame frame;
    private Optional<Parent> root;
    private final ViewFactory<?> viewFactory;

    /**
     * Builds a new {@link JavafxGuiImpl}.
     * 
     * @param <S>   the scenes of the stage
     * @param title the title of the frame
     * @param s     the {@link StageManager}
     */
    public <S> JavafxGuiImpl(final String title, final StageManager<S> s) {
        this.mainStage = Optional.empty();
        this.root = Optional.empty();
        this.frame = new JFrame(title);
        this.viewFactory = new FxmlViewFactoryImpl<>(s);
    }

    @Override
    public final void createGui() {
        this.mainStage = Optional.of(new JFXPanel());
        this.frame.add(this.mainStage.get());
        this.frame.pack();
        this.frame.setMinimumSize(new Dimension(JavafxGuiImpl.MIN_WIDTH, JavafxGuiImpl.MIN_HEIGHT));
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @Override
    public final Scene loadScene(final String fxmlUrl, final GenericController controller) {
        this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
        try {
            this.root = Optional.ofNullable(this.loader.load());
            this.setScene(new Scene(this.root.get()));
            this.root.get().requestFocus();
            controller.setViewController(this.loader.getController());
            ((GenericViewController) this.loader.getController()).setController(controller);
        } catch (IOException e1) {
            e1.printStackTrace();
            this.root = Optional.empty();
        }
        return this.getStageScene();

    }

    @Override
    public final <S> void setScene(final S scene) throws RuntimeException {
        this.mainStage.orElseThrow(() -> new RuntimeException("Main stage optional empty.")).setScene((Scene) scene);
    }

    @Override
    public final FXMLLoader getLoader() {
        return this.loader;
    }

    @Override
    public final Scene getStageScene() throws RuntimeException {
        return this.mainStage.orElseThrow(() -> new RuntimeException("Optional empty.")).getScene();
    }

    @Override
    public final boolean mainStagePresence() {
        return this.mainStage.isPresent();
    }

    @Override
    public final ViewFactory<?> getViewFactory() {
        return this.viewFactory;
    }

}
