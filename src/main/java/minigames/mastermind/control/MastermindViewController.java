package minigames.mastermind.control;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.viewcontroller.MinigameController;
import minigames.mastermind.model.MastermindModelImpl;
import utils.NoticeUserAbstr;
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
        this.mastermindModel.setAttempts(this.attempts);
        this.startGame();
    }

    @FXML
    private void tryGuess() {
        this.mastermindModel.doAttempt();
    }

    @FXML
    private void startNextTurn() {
        this.mastermindModel.runGame();
    }

    @Override
    public final List<U> getGameResults() {
        return this.mastermindModel.gameResults();
    }

    /**
     * This method starts the mastermind minigame.
     */
    private void startGame() {
        this.mastermindModel.setInputField(this.inputField);
        this.mastermindModel.setContinueButton(this.continueButton);
        this.mastermindModel.setEnterButton(this.enterButton);
        this.mastermindModel.setPlayerLabel(this.playerLabel);
        this.mastermindModel.runGame();
    }

}
