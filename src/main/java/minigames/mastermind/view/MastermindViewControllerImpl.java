package minigames.mastermind.view;

import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import minigames.common.view.MinigameViewControllerAbstr;
import minigames.mastermind.controller.MastermindController;
import utils.GuiUtils;
import utils.controller.GenericController;
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
    private void tryGuess() {
        this.mastermindController.doAttempt(this.getGuessAttempt());
    }

    @Override
    @FXML
    public final void startNextTurn() {
        if (this.mastermindController.nextTurn()) {
            this.inputField.setText("");
            GuiUtils.hideLabels(this.attempts);
            GuiUtils.hideNode(this.continueButton);
            this.clearNotice();
            this.enableInput();
        } else {
            this.mastermindController.closeGame();
        }
    }

    @Override
    @FXML
    protected final void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            this.tryGuess();
        }
    }

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MastermindController) {
            this.mastermindController = (MastermindController) controller;
            this.mastermindController.setMaxAttempts(this.attempts.size());
            this.startNextTurn();
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MastermindController");
        }
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
    public final void showTurnResults(final boolean win, final boolean lose, final int score, final String solution,
            final int nAttempts) {
        if (win) {
            this.showNotice("You guessed with " + nAttempts + " attempts. Your score is " + score + ".");
        } else if (lose) {
            this.showNotice("You ended the attempts without guessing the number (" + solution + "). Your score is "
                    + score + ".");
        }
        if (win || lose) {
            GuiUtils.showNode(this.continueButton);
            this.disableInput();
        }
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
