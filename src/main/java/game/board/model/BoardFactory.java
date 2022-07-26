package src.main.java.game.board.model;
/**
 * 
 * This class creates a {@link Board}.
 * 
 */
public interface BoardFactory {
	
	/**
	 * 
	 * @return a {@link Board} object.
	 */
	Board createBoard();
	
}
