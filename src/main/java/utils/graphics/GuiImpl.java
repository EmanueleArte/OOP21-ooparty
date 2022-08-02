package utils.graphics;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Optional;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import utils.GenericViewController;
import utils.controller.GenericController;
import utils.factories.ViewControllerFactory;
import utils.factories.ViewControllerFactoryImpl;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link Gui}.
 */
public class GuiImpl extends JFrame implements Gui {

    private static final long serialVersionUID = -4895173910811030481L;
    /**
     * Minimum window width.
     */
    public static final int MIN_WIDTH = 1000;
    /**
     * Minimum window height.
     */
    public static final int MIN_HEIGHT = 750;
    private final ViewControllerFactory factory;
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
    public <S> GuiImpl(final String title, final StageManager<S> s) {
        this.mainStage = Optional.empty();
        this.root = Optional.empty();
        this.frame = new JFrame(title);
        this.factory = new ViewControllerFactoryImpl();
    }

    @Override
    public final void createGui() {
        this.mainStage = Optional.of(new JFXPanel());
        this.frame.add(this.mainStage.get());
        this.frame.pack();
        this.frame.setMinimumSize(new Dimension(GuiImpl.MIN_WIDTH, GuiImpl.MIN_HEIGHT));
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    @Override
    public final <U> void loadScene(final String fxmlUrl, final Class<?> viewControllerClass,
            final GenericController controller) {
        Platform.runLater(() -> {
            this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
            this.loader.setControllerFactory(this.factory.createViewController(viewControllerClass));
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
    public final Scene getStageScene(final Scene lastScene) {
        if (this.mainStage.isEmpty()) {
            return null;
        }
        Optional<Scene> scene = Optional.empty();
        while (scene.isEmpty() || scene.get().equals(lastScene)) {
            scene = Optional.ofNullable(this.mainStage.get().getScene());
        }
        return scene.get();
    }

    @Override
    public final Optional<JFXPanel> getMainStage() {
        return this.mainStage;
    }

}
