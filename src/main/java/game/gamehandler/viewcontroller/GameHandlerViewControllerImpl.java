package game.gamehandler.viewcontroller;

import game.gamehandler.controller.GameHandlerControllerImpl;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import utils.controller.GenericController;
import utils.GenericViewController;

public class GameHandlerViewControllerImpl implements GenericViewController {
	
	private GameHandlerControllerImpl controller;
	
	@FXML
	private Circle player1;
	@FXML
	private Circle player2;
	@FXML
	private Circle player3;
	@FXML
	private Circle player4;
	
	public void movePlayer(int movement) {
		TranslateTransition transition = new TranslateTransition();
		transition.setNode(player1);
		transition.setDuration(Duration.millis(1000));
		transition.setByX(player1.getLayoutX() + movement*10);
		transition.play();
	}
	
	@Override
	public void setController(GenericController controller) {
		this.controller = (GameHandlerControllerImpl) controller;
	}
	
	public void nextStep() {
		int res = this.controller.nextStep();
		if(res>0) {
			movePlayer(res);
		}
	}
}
