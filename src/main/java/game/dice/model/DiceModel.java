package game.dice.model;

public interface DiceModel<P> {

    void rollDice();

    void returnToGame();

    int getResult();
}
