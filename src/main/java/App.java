import menu.mainmenu.MainMenuControl;
import menu.mainmenu.MainMenuControlImpl;

public class App {

    /**
     * Entry point.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {
        final MainMenuControl mainMenu = new MainMenuControlImpl();
        mainMenu.showMenu();
    }
    
}
