package minigames.mastermind.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import minigames.common.model.MinigameModelAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link NoticeUser} and extension of
 * {@link minigames.common.model.MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> implements MastermindModel<S, U> {

    private static final String EMPTY_STRING = "";
    private int maxAttempts;
    private String solution;
    private int nAttempts;
    private int score;
    private boolean win = false;
    private boolean lose = false;

    /**
     * Builds a new {@link MastermindModelImpl}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public MastermindModelImpl(final List<U> players, final StageManager<S> s) {
        super(players, s);
    }

    @Override
    public final boolean runGame() {
        if (this.hasNextPlayer()) {
            this.nAttempts = 0;
            this.setWin(false);
            this.setLose(false);
            this.solution = this.generateSolution();
            this.setCurrPlayer();
            return true;
        }
        return false;
    }

    @Override
    public final boolean getWin() {
        return this.win;
    }

    @Override
    public final boolean getLose() {
        return this.lose;
    }

    @Override
    public final int getNAttempts() {
        return this.nAttempts;
    }

    @Override
    public final int getScore() {
        return this.score;
    }

    @Override
    public final String getSolution() {
        return this.solution;
    }

    @Override
    public final void setMaxAttempts(final int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public final String doAttempt(final String attempt) {
        if (this.checkAttempt(attempt)) {
            this.nAttempts++;
            Integer nDigitPresent = this.checkDigitsPresence(attempt);
            Integer nDigitExact = this.checkDigitsPosition(attempt);
            this.winCheck(nDigitExact);
            return this.createAttemptLabel(attempt, nDigitPresent, nDigitExact);
        } else {
            return MastermindModelImpl.EMPTY_STRING;
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
    private boolean checkAttempt(final String attempt) {
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
     * This method controls if the attempt is equal to the solution and saves the
     * score.
     * 
     * @param nDigitExact the number of correct digits in correct position
     */
    private void winCheck(final Integer nDigitExact) {
        if (nDigitExact == 4) {
            this.score = this.maxAttempts - this.nAttempts + 1;
            this.scoreMapper(this.getCurrPlayer(), this.score);
            this.setWin(true);
        } else {
            this.loseCheck();
        }
    }

    /**
     * This method controls if the attempts are ended without guessing the 4-digit
     * number.
     */
    private void loseCheck() {
        if (this.nAttempts == this.maxAttempts) {
            this.score = this.maxAttempts - this.nAttempts;
            this.scoreMapper(this.getCurrPlayer(), this.score);
            this.setLose(true);
        }
    }

    /**
     * Setter for win.
     * 
     * @param win true if the current player has guessed the 4-digit number
     */
    private void setWin(final boolean win) {
        this.win = win;
    }

    /**
     * Setter for lose.
     * 
     * @param lose true if the current player hasn't guessed the 4-digit number and
     *             the attempts are ended
     */
    private void setLose(final boolean lose) {
        this.lose = lose;
    }

    /**
     * This method controls the number of digit that are present in the solution and
     * in the attempt.
     * 
     * @param attempt the 4-digit number written by the player
     * @return the number of common digits
     */
    private Integer checkDigitsPresence(final String attempt) {
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
    private Integer checkDigitsPosition(final String attempt) {
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

}
