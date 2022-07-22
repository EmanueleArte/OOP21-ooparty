package minigames.mastermind.viewcontroller;

import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.viewcontroller.MinigameController;
import minigames.mastermind.model.MastermindModelImpl;
import utils.NoticeUserAbstr;
import utils.enums.Notice;
import utils.graphics.StageManager;

/**
 * This class models the mastermind view controller.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindViewController<S, U> extends NoticeUserAbstr implements MinigameController {

    private final MastermindModelImpl<S, U> mastermindModel;
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
     * @param s       the {@link utils.graphics.StageManager}
     * @param players the list of players
     */
    public MastermindViewController(final StageManager<S> s, final List<U> players) {
        this.mastermindModel = new MastermindModelImpl<>(players, s);
    }

    @FXML
    private void initialize() {
        this.startNextTurn();
    }

    @FXML
    private void tryGuess() {
        final String attemptDone = this.mastermindModel.doAttempt(this.getGuessAttempt());
        if (attemptDone.isEmpty()) {
            this.showNotice(Notice.MASTERMIND_INPUT_ERROR.getNotice());
        } else {
            this.showAttempt(attemptDone);
        }
    }

    /**
     * This method starts the mastermind minigame next turn.
     */
    @FXML
    private void startNextTurn() {
        this.hideAttempts();
        this.hideContinueButton();
        // this.clearNotice();
        // this.enableInput();
        // this.getPlayerLabel().setTextFill(((Player) this.currPlayer).getColor());
        // this.getPlayerLabel().setText(((Player) this.currPlayer).getNickname() + "'s
        // turn");
        // this.showNotice(solution);
        this.mastermindModel.runGame();
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

}
