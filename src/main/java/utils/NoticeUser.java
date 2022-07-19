package utils;

import javafx.scene.control.Label;

/**
 * This interface models the a class which uses a notice label.
 */
public interface NoticeUser {

    /**
     * This method sets the notice label.
     * 
     * @param noticeLabel the {@link Label} where is shown a notice
     */
    void setNotice(Label noticeLabel);

    /**
     * This method clears the notice label.
     */
    void clearNotice();

    /**
     * This method shows a notice into the notice label.
     * 
     * @param notice the notice to show
     */
    void showNotice(String notice);

}
