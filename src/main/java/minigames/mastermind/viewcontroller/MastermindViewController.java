package minigames.mastermind.viewcontroller;

import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.viewcontroller.MinigameController;
import minigames.mastermind.model.MastermindModel;
import minigames.mastermind.model.MastermindModelImpl;
import utils.NoticeUserAbstr;
import utils.enums.Notice;
import utils.graphics.StageManagerController;
import game.player.Player;

/**
 * This class models the mastermind view controller.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindViewController<S, U> extends NoticeUserAbstr implements MinigameController {

    private final MastermindModel<S, U> mastermindModel;
    @FXML
    private List<Label> attempts;
    @FXML
    private TextField inputField;
    @FXML
    private Label noticeLabel;
    @FXML
    private Label playerLabel;
    @FXML
    private Button enterButton;
    @FXML
    private Button continueButton;

    /**
     * Builds a new {@link MastermindViewController}.
     * 
     * @param s       the {@link utils.graphics.StageManagerController}
     * @param players the list of players
     */
    public MastermindViewController(final StageManagerController<S> s, final List<U> players) {
        this.mastermindModel = new MastermindModelImpl<>(players, s);
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
            this.hideAttempts();
            this.hideContinueButton();
            this.clearNotice();
            this.enableInput();
            this.playerLabel.setTextFill(((Player) this.mastermindModel.getCurrPlayer()).getColor());
            this.playerLabel.setText(((Player) this.mastermindModel.getCurrPlayer()).getNickname() + "'s turn");
        }
    }

    /**
     * This method shows the attempt done if it is valid.
     * 
     * @param attemptDone the attempt string, it is empty if the attempt is invalid
     */
    private void showAttemptDone(final String attemptDone) {
        if (attemptDone.isEmpty()) {
            this.showNotice(Notice.MASTERMIND_INPUT_ERROR.getNotice());
        } else {
            this.showAttempt(attemptDone);
        }
    }

    /**
     * This method shows the results of the turn.
     */
    private void showTurnResults() {
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

    @Override
    public final List<U> getGameResults() {
        return this.mastermindModel.gameResults();
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
