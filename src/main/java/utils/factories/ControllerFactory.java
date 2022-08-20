package utils.factories;

import java.util.List;

import game.player.Player;
import utils.controller.GenericController;
import menu.afterminigamemenu.controller.AfterMinigameMenuController;
import menu.common.controller.MenuController;
import minigames.common.controller.MinigameController;

public interface ControllerFactory {
    
    GenericController createGameHandlerController(List<Player> players, int turnsNumber);
    
    GenericController createDiceController();

    MenuController createMainMenuController();
    
    MenuController createGameCreationMenuController();
    
    MenuController createPauseMenuController();
    
    AfterMinigameMenuController createAfterMinigameController();
    
    MinigameController createMastermindController();
    
    MinigameController createWhoRisksWinsController();
    
    MinigameController createMemoController();
}
