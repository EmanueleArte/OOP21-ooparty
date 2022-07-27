package utils;

/**
 * This interface models a notice user (a class that uses a notice label).
 */
public interface NoticeUser {

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
