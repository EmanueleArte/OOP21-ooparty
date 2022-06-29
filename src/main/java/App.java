import java.util.List;

import game.gamehandler.model.GameHandler;
import game.gamehandler.model.GameHandlerImpl;
import game.player.PlayerImpl;
import javafx.scene.Scene;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import utils.graphics.StageManager;
import utils.graphics.StageManagerImpl;

public class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
    	final StageManager<Scene> stageManager = new StageManagerImpl<>("OOparty");
        stageManager.run();
        final MainMenuView<Scene> mainMenu = new MainMenuViewImpl<>(stageManager);
        mainMenu.createMainMenu();
        
        GameHandler game = new GameHandlerImpl(stageManager, List.of(new PlayerImpl("Mario"), new PlayerImpl("Luigi"), new PlayerImpl("Yoshi")));
        game.start();
    }
    
}
