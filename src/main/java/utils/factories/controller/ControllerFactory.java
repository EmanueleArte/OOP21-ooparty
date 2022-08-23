package utils.factories.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.gamehandler.controller.GameHandlerController;
import game.player.Player;
import menu.common.controller.MenuController;
import menu.powerupmenu.controller.PowerupMenuController;
import minigames.common.controller.MinigameController;

/**
 * This interface represents a factory for the controllers. When a controller is
 * needed, it can be created from this factory.
 */
public interface ControllerFactory {

    /**
     * This method creates a {@link GameHandlerController}.
     * 
     * @param players     the list of {@link Player} that participates to the game.
     * @param turnsNumber the number of turns.
     * @return the {@link GameHandlerController} created.
     */
    GameHandlerController createGameHandlerController(List<Player> players, int turnsNumber);

    /**
     * This method creates a {@link DiceController}.
     * 
     * @param noRepeat true if you don't want the dice to repeat the numbers else
     *                 false.
     * @return the {@link DiceController} created.
     */
    DiceController createDiceController(boolean noRepeat);

    /**
     * This method creates a {@link MenuController} for the main menu.
     * 
     * @return the main menu controller created.
     */
    MenuController createMainMenuController();

    /**
     * This method creates a {@link MenuController} for the game creation menu.
     * 
     * @return the game creation menu controller created.
     */
    MenuController createGameCreationMenuController();

    /**
     * This method creates a {@link MenuController} for the pause menu.
     * 
     * @return the pause menu controller created.
     */
    MenuController createPauseMenuController();

    /**
     * This method creates a {@link MenuController} for the after minigame menu.
     * 
     * @return the after minigame menu created.
     */
    MenuController createAfterMinigameMenuController();

    /**
     * This method creates a
     * {@link minigames.mastermind.controller.MastermindController
     * MastermindController} for the minigame mastermind.
     * 
     * @param players the list of {@link Player} that participates to the minigame.
     * @return the {@link MinigameController} created.
     */
    MinigameController createMastermindController(List<Player> players);

    /**
     * This method creates a
     * {@link minigames.whoriskswins.controller.WhoRisksWinsController
     * WhoRisksWinsController}.
     * 
     * @param players the list of {@link Player} that participates to the minigame.
     * @return the {@link MinigameController} created.
     */
    MinigameController createWhoRisksWinsController(List<Player> players);

    /**
     * This method creates a {@link minigames.memo.controller.MemoController
     * MemoController}.
     * 
     * @param players the list of {@link Player} that participates to the minigame.
     * @return the {@link MinigameController} created.
     */
    MinigameController createMemoController(List<Player> players);

    /**
     * This method creates a
     * {@link minigames.cutFromTheTeam.controller.CutFromTheTeamController
     * CutFromTheTeamController}.
     *
     * @param players the list of {@link Player} that participates to the minigame.
     * @return the
     *         {@link minigames.cutFromTheTeam.controller.CutFromTheTeamController
     *         CutFromTheTeamController} created.
     */
    MinigameController createCutFromTheTeamController(List<Player> players);

    /**
     * This method creates a {@link PowerupMenuController}.
     * 
     * @param players the list of {@link Player} in the game.
     * @return the {@link PowerupMenuController} created.
     */
    PowerupMenuController createPowerupMenuController(List<Player> players);

}
