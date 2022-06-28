import javafx.scene.Scene;
import menu.mainmenu.control.MainMenuController;
import menu.mainmenu.control.MainMenuControllerImpl;
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
    	final StageManager<Scene> stageManager = new StageManagerImpl<>();
        stageManager.run();
    }
    
}
