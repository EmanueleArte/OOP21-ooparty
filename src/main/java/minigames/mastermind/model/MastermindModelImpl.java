package minigames.mastermind.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.model.MinigameModelAbstr;
import utils.NoticeUser;
import utils.graphics.StageManager;

/**
 * Implementation of {@link NoticeUser} and extension of
 * {@link minigames.common.model.MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> implements NoticeUser {

    private List<Label> attempts;
    private Label noticeLabel;
    private TextField inputField;
    private String solution;

    public MastermindModelImpl(final List<U> players, final StageManager<S> s) {
        super(players, s);
    }

    @Override
    public final void runGame() {
        this.solution = this.generateSolution();
        this.hideAttempts();
    }

    @Override
    public final void setNotice(final Label noticeLabel) {
        this.noticeLabel = noticeLabel;
    }

    @Override
    public final void clearNotice() {
        this.noticeLabel.setText("");
    }

    @Override
    public final void showNotice(final String notice) {
        this.noticeLabel.setText(notice);
    }

    /**
     * This method sets the input field.
     * 
     * @param inputField the {@link TextField} where a player puts his input
     */
    public void setInputField(final TextField inputField) {
        this.inputField = inputField;
    }

    /**
     * This method sets the attempts list.
     * 
     * @param attempts the list of {@link Label} that are the guess attempts of a
     *                 player
     */
    public void setAttempts(final List<Label> attempts) {
        this.attempts = attempts;
    }

    /**
     * This method hides all attempts labels.
     */
    private void hideAttempts() {
        this.attempts.forEach(attempt -> {
            attempt.setVisible(false);
            attempt.setManaged(false);
        });
    }

    /**
     * This method shows an attempt label.
     * 
     * @param attemptLabel the label with the attempt information
     */
    private void showAttempt(final String attemptLabel) {
        Optional<Label> currAttempt = this.attempts.stream()
                .filter(attempt -> {
                    return !attempt.isVisible();
                })
                .findFirst();
        currAttempt.get().setText(attemptLabel);
        currAttempt.get().setVisible(true);
        currAttempt.get().setManaged(true);
    }

    /**
     * This method gets the content of the input field.
     * 
     * @return the {@link String} into the input field
     */
    private String getGuessAttempt() {
        return this.inputField.getText();
    }

    /**
     * This method generates the 4-digit to guess.
     * 
     * @return number the 4-digit number generated
     */
    private String generateSolution() {
        String number = "";
        String[] digitArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List<String> digits = Stream.of(digitArray).collect(Collectors.toList());
        while (number.length() < 4) {
            int index = new Random().nextInt(digits.size());
            number += digits.get(index);
            digits.remove(index);
        }
        return number;
    }

    /**
     * This method controls the attempt of the player.
     */
    public void doAttempt() {

    }

}
