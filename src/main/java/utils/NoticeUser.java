package utils;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This class models a class that uses a notice label.
 */
public class NoticeUser {

    @FXML
    private Label noticeLabel;

    public NoticeUser() {
    }

    /**
     * This method clears the notice text.
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
