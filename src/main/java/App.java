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
    }
    
}
