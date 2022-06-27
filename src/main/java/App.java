import menu.mainmenu.control.MainMenuController;
import menu.mainmenu.control.MainMenuControllerImpl;

public class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
        final MainMenuController mainMenu = new MainMenuControllerImpl();
        mainMenu.showMenu();
    }
    
}
