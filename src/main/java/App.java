import java.util.List;

import game.gamehandler.model.GameHandler;
import game.gamehandler.model.GameHandlerImpl;
import game.map.GameMap;
import game.map.GameMapImpl;
import game.player.PlayerImpl;
import javafx.scene.Scene;
import menu.MenuController;
import menu.mainmenu.controller.MainMenuControllerImpl;
import minigames.whoriskswins.controller.WhoRisksWinsController;
import minigames.whoriskswins.controller.WhoRisksWinsControllerImpl;
import utils.enums.PlayerColor;
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
<<<<<<< HEAD
        final MenuController mainMenu = new MainMenuControllerImpl(stageManager);
        mainMenu.createMenu();
=======
        final MainMenuView<Scene> mainMenu = new MainMenuViewImpl<>(stageManager);
        mainMenu.createMainMenu();
        final GameMap gameMap = new GameMapImpl(null);
>>>>>>> map

        GameHandler game = new GameHandlerImpl(stageManager,
                List.of(new PlayerImpl("Mario"), new PlayerImpl("Luigi"), new PlayerImpl("Yoshi")), gameMap);
        game.start();
    }

    private App() {

    }

}
