import java.util.List;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
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
        
        DiceModel dice = new DiceModelImpl();
        for(int i=0;i<10;i++) {
        	System.out.println("\nRisultato: "+dice.rollDice(null));
        	System.out.println("Spareggio: ");
        	dice.rollDices(List.of(1, 2, 3, 4)).forEach(r->{
        		System.out.print(" "+r);
        	});
        }
    }
    
}
