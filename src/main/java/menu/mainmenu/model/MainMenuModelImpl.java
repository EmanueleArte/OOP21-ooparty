package menu.mainmenu.model;

/**
 * Implementation of {@link MainMenuModel}.
 */
public class MainMenuModelImpl implements MainMenuModel {

    /**
     * Builds a new {@link MainMenuModelImpl}.
     */
    public MainMenuModelImpl() {
    }

    @Override
    public final void exit() {
        System.exit(0);
    }

}
