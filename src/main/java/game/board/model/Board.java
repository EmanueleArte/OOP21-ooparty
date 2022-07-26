package src.main.java.game.board.model;

import game.player.Player;

/**
 * 
 * This class represents the game board.
 *
 */
public interface Board {
	
	/**
	 * Return the {@link Tile} at a given position.
	 * @param the position of which you want to know the tile. 
	 * @return the corresponding {@link Tile}.
	 */
	Tile getTile(int position);
	
	/**
	 * Applies the effect of the tile on which the player is positionated.
	 * @param player
	 */
	void triggerTile(Player player);
	
}
