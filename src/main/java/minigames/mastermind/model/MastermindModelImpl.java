package minigames.mastermind.model;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.model.MinigameModelAbstr;
import utils.graphics.StageManager;

/**
 * Implementation of {@link NoticeUser} and extension of
 * {@link minigames.common.model.MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> {

    private static final String EMPTY_STRING = "";
    private List<Label> attempts;
    private TextField inputField;
    private String solution;
    private Button continueButton;
    private Button enterButton;
    private int nAttempts;

    /**
     * Builds a new {@link GameCreationMenuViewImpl}.
     * 
     * @param players the list of players
     * @param s       the {@link utils.graphics.StageManager}
     */
    public MastermindModelImpl(final List<U> players, final StageManager<S> s) {
        super(players, s);
    }

    @Override
    public final void runGame() {
        if (this.hasNextPlayer()) {
            this.nAttempts = 0;
            this.solution = this.generateSolution();
            this.setCurrPlayer();
        }
    }

    /**
     * This method generates the 4-digit number to guess.
     * 
     * @return number the 4-digit number generated
     */
    private String generateSolution() {
        String number = "";
        String[] digitArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        List<String> digits = Stream.of(digitArray).collect(Collectors.toList());
        while (number.length() < 4) {
            int index = new Random().nextInt(digits.size());
            number += digits.get(index);
            digits.remove(index);
        }
        return number;
    }

    /**
     * This method controls if the attempt is valid.
     * 
     * @param attempt the 4-digit number written by the player
     * @return true if the attempt is a 4-digit number with all different digits
     */
    private boolean controlAttempt(final String attempt) {
        if (attempt.length() != 4) {
            return false;
        }
        for (char c : attempt.toCharArray()) {
            if (Character.isLetter(c)) {
                return false;
            }
        }
        StringBuilder sb = new StringBuilder();
        attempt.chars().distinct().forEach(c -> sb.append((char) c));
        if (sb.length() < 4) {
            return false;
        }
        return true;
    }

    /**
     * This method controls the attempt of the player.
     * 
     * @return the attempt string if the attempt is valid, null otherwise
     */
    public String doAttempt(final String attempt) {
        if (this.controlAttempt(attempt)) {
            this.nAttempts++;
            Integer nDigitPresent = this.controlDigitsPresence(attempt);
            Integer nDigitExact = this.controlDigitsPosition(attempt);
            this.winControl(nDigitExact);
            return this.createAttemptLabel(attempt, nDigitPresent, nDigitExact);
        } else {
            return MastermindModelImpl.EMPTY_STRING;
        }
    }

    /**
     * This method controls if the attempt is equal to the solution and saves the
     * score.
     * 
     * @param nDigitExact the number of correct digits in correct position
     */
    private void winControl(final Integer nDigitExact) {
        if (nDigitExact == 4) {
            final int score = this.attempts.size() - this.nAttempts + 1;
            this.scoreMapper(this.getCurrPlayer(), score);
            this.showContinueButton();
            // this.showNotice("You guessed with " + this.nAttempts + " attempts. Your score
            // is " + score + ".");
            this.disableInput();
        } else {
            this.loseControl();
        }
    }

    /**
     * This method controls if the attempts are ended without guessing the 4-digit
     * number.
     */
    private void loseControl() {
        if (this.nAttempts == this.attempts.size()) {
            final int score = this.attempts.size() - this.nAttempts;
            this.scoreMapper(this.getCurrPlayer(), score);
            this.showContinueButton();
            // this.showNotice("You ended the attempts without guessing the number. Your
            // score is " + score + ".");
            this.disableInput();
        }
    }

    /**
     * This method controls the number of digit that are present in the solution and
     * in the attempt.
     * 
     * @param attempt the 4-digit number written by the player
     * @return the number of common digits
     */
    private Integer controlDigitsPresence(final String attempt) {
        Integer nDigit = 0;
        for (int i = 0; i < 4; i++) {
            if (this.solution.contains(String.valueOf(attempt.charAt(i)))) {
                nDigit++;
            }
        }
        return nDigit;
    }

    /**
     * This method controls the number of digit which are in common between the
     * solution and the attempt that are also in the same position.
     * 
     * @param attempt the 4-digit number written by the player
     * @return the number of common and equal positioned digits
     */
    private Integer controlDigitsPosition(final String attempt) {
        Integer nDigit = 0;
        for (int i = 0; i < 4; i++) {
            if (this.solution.charAt(i) == attempt.charAt(i)) {
                nDigit++;
            }
        }
        return nDigit;
    }

    /**
     * This method creates an attempt label.
     * 
     * @param attempt       the 4-digit number written by the player
     * @param nDigitPresent the number of common digits
     * @param nDigitExact   the number of common digits in the same position
     * @return the attempt label to show
     */
    private String createAttemptLabel(final String attempt, final Integer nDigitPresent, final Integer nDigitExact) {
        return attempt + "\n" + nDigitPresent + " common digits of \nwhich " + nDigitExact + " in correct position.";
    }

    /**
     * Setter for continueButton.
     * 
     * @param continueButton the {@link Button} to the next turn
     */
    public void setContinueButton(final Button continueButton) {
        this.continueButton = continueButton;
    }

    /**
     * This method hides the continue button.
     */
    private void hideContinueButton() {
        this.continueButton.setVisible(false);
        this.continueButton.setManaged(false);
    }

    /**
     * This method shows the continue button.
     */
    private void showContinueButton() {
        this.continueButton.setVisible(true);
        this.continueButton.setManaged(true);
    }

    /**
     * This method disables the input when the current turn is ended.
     */
    private void disableInput() {
        this.inputField.setText("");
        this.inputField.setDisable(true);
        this.enterButton.setDisable(true);
    }

    /**
     * This method enables the input when the current turn is started.
     */
    private void enableInput() {
        this.inputField.setDisable(false);
        this.enterButton.setDisable(false);
    }

}
