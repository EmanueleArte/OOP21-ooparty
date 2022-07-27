package minigames.common.viewcontroller;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import utils.NoticeUserAbstr;

/**
 * Extension of {@link NoticeUserAbstr}.
 */
public abstract class MinigameViewControllerAbstr extends NoticeUserAbstr implements MinigameViewController {

    @FXML
    private Label playerLabel;

    public MinigameViewControllerAbstr() {
    }

    @Override
    public abstract void startNextTurn();

    @Override
    public final void setPlayerLabelText(final Player player) {
        this.playerLabel.setTextFill((player.getColor()));
        this.playerLabel.setText((player.getNickname() + "'s turn"));
    }

}
