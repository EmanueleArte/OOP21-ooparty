package utils;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This abstract class models a class that uses a notice label.
 */
public class NoticeUserAbstr implements NoticeUser {

    @FXML
    private Label noticeLabel;

    public NoticeUserAbstr() {

    }

    @FXML
    @Override
    public final void clearNotice() {
        this.noticeLabel.setText("");
    }

    /**
     * This method shows a notice into the notice label.
     * 
     * @param notice the notice to show
     */
    @Override
    public final void showNotice(final String notice) {
        this.noticeLabel.setText(notice);
    }

}
