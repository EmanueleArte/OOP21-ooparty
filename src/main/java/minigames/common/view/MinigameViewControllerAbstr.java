package minigames.common.view;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import utils.NoticeUser;

/**
 * Extension of {@link NoticeUser} and implementation of
 * {@link MinigameViewController}.
 */
public abstract class MinigameViewControllerAbstr extends NoticeUser implements MinigameViewController {

    @FXML
    private Label playerLabel;
    @FXML
    private Group playerAvatar;

    public MinigameViewControllerAbstr() {
    }

    @Override
    public abstract void startNextTurn();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlayerLabelText(final Player player) {
        this.playerLabel.setTextFill((player.getColor()));
        this.playerLabel.setText((player.getNickname() + "'s turn"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlayerAvatarColor(final Player player) {
        this.playerAvatar.getChildren().forEach(shape -> {
            ((Shape) shape).setFill(player.getColor());
        });
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
