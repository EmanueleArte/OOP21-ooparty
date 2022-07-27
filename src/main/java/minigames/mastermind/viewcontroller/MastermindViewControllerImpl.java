package minigames.mastermind.viewcontroller;

import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import minigames.common.viewcontroller.MinigameViewControllerAbstr;
import minigames.mastermind.controller.MastermindController;
import utils.GenericController;
import utils.enums.Notice;

/**
 * Extension of {@link MinigameViewControllerAbstr} and implementation of
 * {@link MastermindViewController}.
 */
public class MastermindViewControllerImpl extends MinigameViewControllerAbstr implements MastermindViewController {

    private MastermindController mastermindController;
    @FXML
    private List<Label> attempts;
    @FXML
    private TextField inputField;
    @FXML
    private Button enterButton;
    @FXML
    private Button continueButton;

    /**
     * Builds a new {@link MastermindViewControllerImpl}.
     */
    public MastermindViewControllerImpl() {
    }

    @FXML
    private void initialize() {
        this.mastermindModel.setMaxAttempts(this.attempts.size());
        this.startNextTurn();
    }

    @FXML
    private void tryGuess() {
        final String attemptDone = this.mastermindModel.doAttempt(this.getGuessAttempt());
        this.showAttemptDone(attemptDone);
        this.showTurnResults();
    }

    /**
     * This method starts the mastermind minigame next turn.
     */
    @FXML
    private void startNextTurn() {
        if (this.mastermindModel.runGame()) {
            this.inputField.setText("");
            this.hideAttempts();
            this.hideContinueButton();
            this.clearNotice();
            this.enableInput();
            this.setPlayerLabelText(this.mastermindModel);
        }
    }

    /**
     * This method performs an action when the "ENTER" key is clicked.
     * 
     * @param ke the {@link KeyEvent}
     */
    @FXML
    private void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            this.tryGuess();
        }
    }

    @Override
    public final void setController(final GenericController controller) {
        this.mastermindController = (MastermindController) controller;
    }

    @Override
    public final void showAttemptDone(final String attemptDone) {
        if (attemptDone.isEmpty()) {
            this.showNotice(Notice.MASTERMIND_INPUT_ERROR.getNotice());
        } else {
            this.showAttempt(attemptDone);
        }
    }

    @Override
    public final void showTurnResults() {
        final boolean win = this.mastermindModel.getWin();
        final boolean lose = this.mastermindModel.getLose();
        if (win) {
            this.showNotice("You guessed with " + this.mastermindModel.getNAttempts() + " attempts. Your score is "
                    + this.mastermindModel.getScore() + ".");
        } else if (lose) {
            this.showNotice("You ended the attempts without guessing the number (" + this.mastermindModel.getSolution()
                    + "). Your score is " + this.mastermindModel.getScore() + ".");
        }
        if (win || lose) {
            this.showContinueButton();
            this.disableInput();
        }
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
        Optional<Label> currAttempt = this.attempts.stream().filter(attempt -> {
            return !attempt.isVisible();
        }).findFirst();
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
