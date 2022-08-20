package utils.factories;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import utils.controller.GenericController;
import menu.common.controller.MenuController;
import minigames.common.controller.MinigameController;

public interface ControllerFactory {

    GenericController createGameHandlerController(List<Player> players, int turnsNumber);

    DiceController createDiceController();

    MenuController createMainMenuController();

    MenuController createGameCreationMenuController();

    MenuController createPauseMenuController();

    MenuController createAfterMinigameController();

    MinigameController createMastermindController(List<Player> players);

    MinigameController createWhoRisksWinsController(List<Player> players);

    MinigameController createMemoController(List<Player> players);
}
