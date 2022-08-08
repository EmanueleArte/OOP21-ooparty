package game.dice.controller;

import java.util.Optional;

import game.player.Player;

public interface DiceController {

    void returnToGame();

    void rollDice();

    void start(Player p);

    Optional<Integer> getLastResult();

}
