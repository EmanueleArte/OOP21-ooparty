import java.util.List;

import game.gamehandler.model.GameHandler;
import game.gamehandler.model.GameHandlerImpl;
import game.player.PlayerImpl;
import javafx.scene.Scene;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import utils.graphics.StageManagerController;
import utils.graphics.StageManagerControllerImpl;

public final class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
        final StageManagerController<Scene> stageManager = new StageManagerControllerImpl<>("OOparty");
        stageManager.run();
        final MainMenuView<Scene> mainMenu = new MainMenuViewImpl<>(stageManager);
        mainMenu.createMainMenu();

        GameHandler game = new GameHandlerImpl(stageManager,
                List.of(new PlayerImpl("Mario"), new PlayerImpl("Luigi"), new PlayerImpl("Yoshi")));
        game.start();
    }

    private App() {

    }

}
