import java.util.List;

import game.gamehandler.model.GameHandler;
import game.gamehandler.model.GameHandlerImpl;
import game.player.PlayerImpl;
import javafx.scene.Scene;
import menu.mainmenu.controller.MainMenuController;
import menu.mainmenu.controller.MainMenuControllerImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import utils.graphics.stagemanager.StageManager;
import utils.graphics.stagemanager.StageManagerImpl;

public final class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
        final StageManager<Scene> stageManager = new StageManagerImpl<>("OOparty");
        stageManager.run();
        final MainMenuController mainMenu = new MainMenuControllerImpl(stageManager);

        GameHandler game = new GameHandlerImpl(stageManager,
                List.of(new PlayerImpl("Mario"), new PlayerImpl("Luigi"), new PlayerImpl("Yoshi")));
        game.start();
    }

    private App() {

    }

}
