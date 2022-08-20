
import game.map.GameMap;
import game.map.GameMapImpl;
import javafx.scene.Scene;
import menu.common.controller.MenuController;
import menu.mainmenu.controller.MainMenuControllerImpl;
import utils.factories.ControllerFactory;
import utils.factories.ControllerFactoryFx;
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
        ControllerFactory controllerFactory = new ControllerFactoryFx(stageManager);
        stageManager.setControllerFactory(controllerFactory);
        stageManager.run();
        
        stageManager.getControllerFactory().createMainMenuController().createMenu();
        
        
        //final MenuController mainMenu = new MainMenuControllerImpl(stageManager);
        //mainMenu.createMenu();
        //final GameMap gameMap = new GameMapImpl(null);

        /*
         * GameHandlerModel game = new GameHandlerModelImpl(stageManager, List.of(new
         * PlayerImpl("Mario"), new PlayerImpl("Luigi"), new PlayerImpl("Yoshi")),
         * gameMap); game.start();
         */
    }

    private App() {

    }

}
