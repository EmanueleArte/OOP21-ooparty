package menu.afterminigamemenu.view;

import java.util.List;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import menu.MenuController;
import menu.afterminigamemenu.controller.AfterMinigameMenuController;
import utils.controller.GenericController;

public class AfterMinigameMenuViewControllerImpl implements AfterMinigameMenuViewController {

    private MenuController menuController;
    private List<Player> players;
    @FXML
    private List<VBox> vBoxes;
    /*@FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;
    @FXML
    private VBox vBox3;
    @FXML
    private VBox vBox4;*/

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

    @Override
    public final void makeLeaderboard(final List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Label position = (Label) vBoxes.get(i).getChildren().get(0);
            position.setText(this.getPositionFromIndex(i));
            Label playerNickname = (Label) vBoxes.get(i).getChildren().get(1);
            playerNickname.setText(players.get(i).getNickname());
        }
    }

    private String getPositionFromIndex(final int i) {
        if (i == 0) {
            return "1st";
        } else if (i == 1) {
            return "2nd";
        } else if (i == 2) {
            return "3rd";
        }
        return (i + 1) + "th";
    }

    @FXML
    private void exitMenu() {
        this.menuController.exit();
    }
}
