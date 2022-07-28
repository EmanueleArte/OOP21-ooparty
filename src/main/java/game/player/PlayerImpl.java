package game.player;

import java.util.Objects;

import game.map.GameMap;
import game.map.GameMapBox;
import javafx.scene.paint.Color;

/**
 * The implementation of {@link Player}.
 */
public class PlayerImpl implements Player {

    private final String nickname;
    private final Color color;
    private int coins;
    private int stars;
    private int lifePoints;

    /**
     * The maximum amount of life points.
     */
    public static final int MAX_LIFE = 100;

    /**
     * Builds a new {@link PlayerImpl}.
     * 
     * @param nickname the selected nickname
     * @param color the selected color
     */
    public PlayerImpl(final String nickname, final Color color) {
        this.nickname = nickname;
        this.color = color;
        this.coins = 0;
        this.stars = 0;
        this.lifePoints = PlayerImpl.MAX_LIFE;
    }

    public PlayerImpl(final String nickname) {
        this(nickname, null);
    }

    @Override
    public final String getNickname() {
        return this.nickname;
    }

    @Override
    public final Color getColor() {
        return this.color;
    }

    @Override
    public final void moveForward(final int n) {
        //TODO da modificare
        //this.position += n;
    }

    @Override
    public void goTo(final GameMap gameMap, final GameMapBox newGameMapBox) {
        GameMapBox currentPosition = this.getPosition(gameMap);
        newGameMapBox.addPlayer(this);
        currentPosition.removePlayer(this);
    }

    @Override
    public final GameMapBox getPosition(final GameMap gameMap) {
        return gameMap.getPlayerPosition(this);
    }

    @Override
    public final void earnCoins(final int n) {
        this.coins = getCoinsCount() + n;
    }

    @Override
    public final void loseCoins(final int n) {
        this.coins = getCoinsCount() - n;
        if (this.coins < 0) {
            this.coins = 0;
        }
    }

    @Override
    public final void updateCoins(final int n) {
        if (n >= 0) {
            this.coins = n;
        } else {
            throw new IllegalArgumentException("Coins can't be negative");
        }
    }

    @Override
    public final int getCoinsCount() {
        return this.coins;
    }

    @Override
    public final void earnStar() {
        this.stars++;
    }

    @Override
    public final void loseStar() {
        if (this.stars > 0) {
            this.stars--;
        }
    }

    @Override
    public final int getStarsCount() {
        return this.stars;
    }

    @Override
    public final int getLife() {
        return this.lifePoints;
    }

    @Override
    public final void loseLifePoints(final int damage) {
        if (damage <= 0) {
            throw new IllegalArgumentException("Damage can't be 0 or negative");
        }
        this.lifePoints = this.lifePoints - damage;
        if (this.lifePoints <= 0) {
            //TODO player muore
        }
    }

    @Override
    public final void getLifePoints(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount can't be 0 or negative");
        }
        this.lifePoints += amount;
        if (this.lifePoints > PlayerImpl.MAX_LIFE) {
            this.lifePoints = PlayerImpl.MAX_LIFE;
        }
    }

    @Override
    public final int hashCode() {
        return Objects.hash(coins, color, nickname, stars);
    }

    @Override
    public final boolean equals(final Object obj) {
        if  (this == obj) {
            return true;
        }
        if  (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PlayerImpl other = (PlayerImpl) obj;
        return coins == other.coins && Objects.equals(color, other.color) && Objects.equals(nickname, other.nickname)
                && stars == other.stars;
    }

}
