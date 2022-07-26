package minigames.common.viewcontroller;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import minigames.common.model.MinigameModel;
import utils.NoticeUserAbstr;

/**
 * This abstract class models a standard minigame view controller.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the player
 */
public abstract class MinigameViewControllerAbstr<S, U> extends NoticeUserAbstr {

    private MinigameModel<S, U> model;
    @FXML
    private Label playerLabel;

    public MinigameViewControllerAbstr(final MinigameModel<S, U> model) {
        this.model = model;
    }

    /**
     * This method sets the player label with the current player name and color.
     */
    protected void setPlayerLabel() {
        final Player player = (Player) model.getCurrPlayer();
        this.playerLabel.setTextFill((player.getColor()));
        this.playerLabel.setText((player.getNickname() + "'s turn"));
    }

}
