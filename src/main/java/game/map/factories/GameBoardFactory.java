package game.map.factories;

import java.util.List;

import game.map.GameMapSquare;

/**
 * 
 */
public interface GameBoardFactory {
	
	/**
	 * This method returns a list of {@link GameMapSquare} that represents the game board.
	 * @param the size of the board.
	 * @return a list representing the game board.
	 */
	List<GameMapSquare> createGameBoard(int size);
	
}
