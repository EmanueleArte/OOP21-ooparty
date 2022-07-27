package minigames.common.viewcontroller;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import minigames.common.model.MinigameModel;
import utils.NoticeUserAbstr;

/**
 * Extension of {@link NoticeUserAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the player
 */
public abstract class MinigameViewControllerAbstr<S, U> extends NoticeUserAbstr {

    @FXML
    private Label playerLabel;

    public MinigameViewControllerAbstr() {
    }

    /**
     * This method sets the player label with the current player nickname and color.
     * 
     * @param model the minigame model actually used
     */
    protected void setPlayerLabelText(final MinigameModel<S, U> model) {
        final Player player = (Player) model.getCurrPlayer();
        this.playerLabel.setTextFill((player.getColor()));
        this.playerLabel.setText((player.getNickname() + "'s turn"));
    }

}
