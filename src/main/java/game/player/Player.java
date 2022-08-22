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
     * <<<<<<< HEAD
     * 
     * @return the name of the player ======= Returns the player's nickanme.
     * 
     * @return the player's nickname >>>>>>>
     *         169da5602b80ba9ca3fc56a251620ce58f58c58d
     */
    String getNickname();

    /**
     * <<<<<<< HEAD
     * 
     * @return the color of the player ======= Returns the player's color.
     * 
     * @return the player's color. >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
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
     * <<<<<<< HEAD
     * 
     * @param gameMap the map of the game
     * @return the player's position (the square where he is located) =======
     *         Returns the {@link GameMapSquare} where this player is located.
     * 
     * @param gameMap the map of the game
     * @return the player's position (the {@link GameMapSquare} where he is located)
     *         >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
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
     * <<<<<<< HEAD ======= Returns the amount of player's coins.
     * 
     * >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
     * 
     * @return amount of player's coins
     */
    int getCoinsCount();

    /**
     * <<<<<<< HEAD Make player earn a star. ======= Makes the player earn a star.
     * >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
     */
    void earnStar();

    /**
     * <<<<<<< HEAD Make player lose a star. ======= Makes the player lose a star.
     * >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
     */
    void loseStar();

    /**
     * <<<<<<< HEAD
     * 
     * @return number of player'stars ======= Returns the number of player'stars.
     * 
     * @return the number of player'stars >>>>>>>
     *         169da5602b80ba9ca3fc56a251620ce58f58c58d
     */
    int getStarsCount();

    /**
     * <<<<<<< HEAD
     * 
     * @return the amount of life points ======= Returns the amount of this player's
     *         life points.
     * 
     * @return the amount of this player's life points >>>>>>>
     *         169da5602b80ba9ca3fc56a251620ce58f58c58d
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
     * <<<<<<< HEAD
     * 
     * @param damage  the amount of life to be taken away =======
     * @param damage  the amount of life to be taken away
     * @param gameMap the game map (used to move the {@link Player} if he dies)
     *                >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
     */
    void loseLifePoints(int damage);

    /**
     * Sets number of dices to roll during the next turn.
     * 
     * @param n the number of dices to roll
     */
    void setDicesNumber(int n);

    /**
     * <<<<<<< HEAD
     * 
     * @return int containing the number of dices the player has to roll =======
     * 
     *         Returns an {@link int} containing the number of dices the player has
     *         to roll.
     * 
     * @return an {@link int} containing the number of dices the player has to roll
     *         >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
     */
    int getDicesToRoll();

    /**
     * <<<<<<< HEAD
     * 
     * @return a list containing all the powerups the player has got. =======
     *         Returns a list containing all the {@link GenericPowerup}s the player
     *         has got.
     * 
     * @return a list containing all the {@link GenericPowerup}s the player has got.
     *         >>>>>>> 169da5602b80ba9ca3fc56a251620ce58f58c58d
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
     * Returns the amount of coins earned the last time this player earned coins.
     * 
     * @return the amount of coins earned the last time this player earned coins
     */
    int getLastEarnedCoins();

    /**
     * Returns the amount of damage taken the last time this player was hit.
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
