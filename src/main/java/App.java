import java.util.List;

import game.player.PlayerImpl;
import javafx.scene.Scene;
import utils.enums.PlayerColor;
import utils.factories.controller.ControllerFactory;
import utils.factories.controller.ControllerFactoryFx;
import utils.graphics.controller.StageManager;
import utils.graphics.controller.StageManagerImpl;
import utils.graphics.view.JavafxGuiImpl;

public final class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
        final StageManager<Scene> stageManager = new StageManagerImpl<>("OOparty", JavafxGuiImpl.class);
        ControllerFactory controllerFactory = new ControllerFactoryFx<>(stageManager);
        stageManager.setControllerFactory(controllerFactory);
        stageManager.run();
//        stageManager.getControllerFactory().createMainMenuController().createMenu();
        stageManager.getControllerFactory()
                .createYoureTheBobombController(List.of(new PlayerImpl("" + 1, PlayerColor.RED.getColor()), new PlayerImpl("" + 2, PlayerColor.BLUE.getColor())))
                .startGame();
    }

    private App() {

    }

}
