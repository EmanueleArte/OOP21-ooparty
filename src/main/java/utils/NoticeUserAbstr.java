package utils;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This abstract class models a class that uses a notice label.
 */
public class NoticeUserAbstr {

    @FXML
    private Label noticeLabel;

    public NoticeUserAbstr() {

    }

    /**
     * This method clears the notice label.
     */
    @FXML
    protected void clearNotice() {
        this.noticeLabel.setText("");
    }

    /**
     * This method shows a notice into the notice label.
     * 
     * @param notice the notice to show
     */
    protected void showNotice(final String notice) {
        this.noticeLabel.setText(notice);
    }

}
