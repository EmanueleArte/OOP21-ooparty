import javafx.scene.Scene;
import menu.mainmenu.control.MainMenuController;
import menu.mainmenu.control.MainMenuControllerImpl;
import utils.graphics.StageManager;
import utils.graphics.StageManagerImpl;

public class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
    	final StageManager stageManager = new StageManagerImpl<Scene>();
        final MainMenuController mainMenu = new MainMenuControllerImpl();
        mainMenu.start();
    }
    
}
