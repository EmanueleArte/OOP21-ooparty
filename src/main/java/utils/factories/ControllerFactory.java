package utils.factories;

import java.util.List;

import game.dice.controller.DiceController;
import game.gamehandler.controller.GameHandlerController;
import game.player.Player;
import utils.controller.GenericController;
import menu.common.controller.MenuController;
import minigames.common.controller.MinigameController;

/**
 * This interface represents a factory for the controllers. When a controller is needed, it can be created from this factory.
 */
public interface ControllerFactory {
    
    GameHandlerController createGameHandlerController(List<Player> players, int turnsNumber);
    
    <P> DiceController createDiceController(boolean noRepeat);

    MenuController createMainMenuController();
    
    MenuController createGameCreationMenuController();
    
    MenuController createPauseMenuController();
    
    MenuController createAfterMinigameController();
    
    MinigameController createMastermindController();
    
    MinigameController createWhoRisksWinsController();
    
    MinigameController createMemoController();

}
