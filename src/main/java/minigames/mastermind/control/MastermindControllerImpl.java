package minigames.mastermind.control;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.mastermind.model.MastermindModelImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MastermindController}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindControllerImpl<S, U> implements MastermindController<S, U> {

    private final MastermindModelImpl<S, U> mastermindModel;
    @FXML
    private List<Label> attempts;
    @FXML
    private TextField inputField;
    @FXML
    private Label noticeLabel;

    public MastermindControllerImpl(final StageManager<S> s, final List<U> players) {
        super();
        this.mastermindModel = new MastermindModelImpl<>(players, s);
    }

    @FXML
    private void initialize() {
        this.mastermindModel.setAttempts(this.attempts);
        this.startGame();
    }

    @Override
    public final void tryGuess() {
        this.mastermindModel.doAttempt();
    }

    @Override
    public final void clearNotice() {
        this.mastermindModel.clearNotice();
    }

    /**
     * This method starts the mastermind minigame.
     */
    private void startGame() {
        this.mastermindModel.setNotice(this.noticeLabel);
        this.mastermindModel.setInputField(this.inputField);
        this.mastermindModel.runGame();
    }

}
