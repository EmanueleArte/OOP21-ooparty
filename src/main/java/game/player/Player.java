package game.player;

import java.util.List;

import game.map.GameMap;
import game.map.GameMapSquare;
import game.powerup.GenericPowerup;
import javafx.scene.paint.Color;

/**
 * This interface models one player.
 */
public interface Player {

    /**
     * @return the name of the player
     */
    String getNickname();

    /**
     * @return the color of the player
     */
    Color getColor();

    /**
     * Moves the player forward.
     * 
     * @param n       number of steps
     * @param gameMap the map of the game
     */
    void moveForward(int n, GameMap gameMap);

    /**
     * Moves the player to a certain position.
     * 
     * @param gameMap          the map of the game
     * @param newGameMapSquare the new player's position square
     */
    void goTo(GameMap gameMap, GameMapSquare newGameMapSquare);

    /**
     * 
     * @param gameMap the map of the game
     * @return the player's position (the square where he is located)
     */
    GameMapSquare getPosition(GameMap gameMap);

    /**
     * Increments the player's coins.
     * 
     * @param n coins to add
     */
    void earnCoins(int n);

    /**
     * Decrements the player's coins.
     * 
     * @param n coins to subtract
     */
    void loseCoins(int n);

    /**
     * Updates the player's coins.
     * 
     * @param n new amount of coins
     */
    void updateCoins(int n);

    /**
     * @return amount of player's coins
     */
    int getCoinsCount();

    /**
     * Make player earn a star.
     */
    void earnStar();

    /**
     * Make player lose a star.
     */
    void loseStar();

    /**
     * @return number of player'stars
     */
    int getStarsCount();

    /**
     * @return the amount of life points
     */
    int getLifePoints();

    /**
     * Adds amount life points to the current life points.
     * 
     * @param amount the amount of life points to get
     */
    void addLifePoints(int amount);

    /**
     * Takes away life points from the player.
     * 
     * @param damage the amount of life to be taken away
     */
    void loseLifePoints(int damage);

    /**
     * Sets number of dices to roll during the next turn.
     * 
     * @param n the number of dices to roll
     */
    void setDicesNumber(int n);

    /**
     * @return int containing the number of dices the player has to roll
     */
    int getDicesToRoll();

    /**
     * @return a list containing all the powerups the player has got.
     */
    List<GenericPowerup> getPowerupList();

    /**
     * Adds a {@link GenericPowerup} to this player's powerups list.
     * 
     * @param powerup the powerup to add to the player
     */
    void addPowerup(GenericPowerup powerup);

    /**
     * Uses one powerup and removes it from the list.
     * 
     * @param powerupType type of powerup to use
     */
    void usePowerup(String powerupType, Player target);

    /**
     * Getter for the last amount of coins earned by this player.
     * 
     * @return the amount of coins earned the last time this player earned coins
     */
    int getLastEarnedCoins();

    /**
     * 
     * @return the amount of damage taken the last time this player was hit
     */
    int getLastDamageTaken();

    /**
     * Returns if the last star was earned (true) or if the player didn't have
     * enough coins to earn it (false).
     * 
     * @return if the last star was earned (true) or if the player didn't have
     *         enough coins to earn it (false)
     */
    boolean getIsLastStarEarned();

    /**
     * Sets if the last star was earned.
     * 
     * @param isLastStarEarned if the last star was earned
     */
    void setIsLastStarEarned(boolean isLastStarEarned);

    /**
     * Returns if the player died in the last turn.
     * 
     * @return if the player died in the last turn
     */
    boolean isDead();

    /**
     * Checks if the player is dead and if he is, makes him respawn.
     * 
     * @param gameMap the map of the game
     */
    void checkIfDeadAndRespawn(GameMap gameMap);
}
