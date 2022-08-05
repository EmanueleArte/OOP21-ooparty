package game.dice.controller;

import game.player.Player;

public interface DiceController<S, P> {

    void returnToGame();

    void rollDice();

    void start(Player p);

    int getResult();

}