package menu.powerupmenu.controller;

import java.util.List;

import game.player.Player;

public interface PowerupMenuController {

    void start(Player currentPlayer);

    void returnToGame();

    void usePowerup(String powerupType, String target);

}