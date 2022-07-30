package minigames.common.viewcontroller;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import utils.NoticeUserAbstr;

/**
 * Extension of {@link NoticeUserAbstr}.
 */
public abstract class MinigameViewControllerAbstr extends NoticeUserAbstr implements MinigameViewController {

    @FXML
    private Label playerLabel;
    @FXML
    private Group playerAvatar;

    public MinigameViewControllerAbstr() {
    }

    @Override
    public abstract void startNextTurn();

    @Override
    public final <U> void setPlayerLabelText(final U player) {
        if (player instanceof Player) {
            final Player currPlayer = (Player) player;
            this.playerLabel.setTextFill((currPlayer.getColor()));
            this.playerLabel.setText((currPlayer.getNickname() + "'s turn"));
        }
    }

    @Override
    public final <U> void setPlayerAvatarColor(final U player) {
        if (player instanceof Player) {
            final Player currPlayer = (Player) player;
            this.playerAvatar.getChildren().forEach(shape -> {
                ((Shape) shape).setFill(currPlayer.getColor());
            });
        }
    }

    /**
     * This method performs an action when the "ENTER" key is clicked.
     * 
     * @param ke the {@link KeyEvent}
     */
    @FXML
    protected abstract void onEnter(KeyEvent ke);

    /**
     * Getter for playerAvatar.
     * 
     * @return the player avatar
     */
    protected Group getPlayerAvatar() {
        return this.playerAvatar;
    }

}
