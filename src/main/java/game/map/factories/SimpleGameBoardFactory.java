package game.map.factories;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import game.map.CoinsGameMapSquare;
import game.map.DamageGameMapSquare;
import game.map.GameMapImpl;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;
import game.map.PowerUpGameMapSquare;
import game.map.StarGameMapSquare;
import utils.enums.SquareType;

public class SimpleGameBoardFactory extends FixedSizeGameBoardFactory {

    private enum SquareTypeMaxOccurrences {
        START(GameMapSquareImpl.class, 1),
        DEFAULT(GameMapSquareImpl.class, 100),
        COIN(CoinsGameMapSquare.class, 4),
        POWERUP(PowerUpGameMapSquare.class, 4),
        DAMAGE(DamageGameMapSquare.class, 8),
        STAR(StarGameMapSquare.class, 1);

        private final int maxOccurrences;
        private final Class squareClass;

        SquareTypeMaxOccurrences(final Class squareClass, final int max) {
            this.squareClass = squareClass;
            this.maxOccurrences = max;
        }

        public int getMaxOccurrences() {
            return this.maxOccurrences;
        }

        public Class getSquareClass() {
            return this.squareClass;
        }
    }

    @Override
    public List<GameMapSquare> createGameBoard(final int size) {
        final List<GameMapSquare> board = new ArrayList<>();
        board.add(new GameMapSquareImpl());

        while (board.size() < super.getSize()) {
            GameMapSquare square = getRandomSquare();
            if (squareCanBeAdded(board, square)) {
                board.add(square);
            } else if (boardIsFullOfSpecialSquares(board)) {
                board.addAll(Stream.generate(() -> new GameMapSquareImpl())
                        .limit(super.getSize() - board.size())
                        .collect(Collectors.toList()));
            }
        }

        do {
            Collections.shuffle(board);
        } while (!compareSquares(board.get(0), new GameMapSquareImpl()));

        return board;
    }

    private boolean boardIsFullOfSpecialSquares(final List<GameMapSquare> board) {
        return List.of(SquareTypeMaxOccurrences.values())
                .stream()
                .filter(st -> {
                    try {
                        return squareCanBeAdded(board, (GameMapSquare) st.squareClass.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return false;
                })
                .findAny()
                .isEmpty();
    }

    private boolean squareCanBeAdded(final List<GameMapSquare> board, final GameMapSquare square) {
        Class<?> squareClass = square.getClass();
        GameMapSquare squareClassInstance;
        try {
            squareClassInstance = (GameMapSquare) squareClass.newInstance();
            var elementsCount = board.stream().filter(s -> compareSquares(s, squareClassInstance)).count();

            var maxOcc = List.of(SquareTypeMaxOccurrences.values()).stream().filter(e -> e.getSquareClass().equals(squareClass)).findAny().get().getMaxOccurrences();

            if (compareSquares(square, squareClassInstance) && elementsCount >= maxOcc) {
                return false;
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e1) {
            e1.printStackTrace();
        }
        return true;
    }
    /* TODO: rattoppo, serve equals in GameMapSquareImpl */
    private boolean compareSquares(final GameMapSquare s1, final GameMapSquare s2) {
        return s1.toString().equals(s2.toString());
    }

    private GameMapSquare getRandomSquare() {
        var randSquareType = SquareType.values()[1 + new Random().nextInt(SquareType.values().length - 1)];
        GameMapSquare square;

        switch (randSquareType) {
        case COIN:
            square = new CoinsGameMapSquare();
            break;
        case POWERUP:
            square = new PowerUpGameMapSquare();
            break;
        case DAMAGE:
            square = new DamageGameMapSquare();
            break;
        case STAR:
            square = new StarGameMapSquare();
            break;
        default:
            square = new GameMapSquareImpl();
            break;
        }

        return square;
    }
}
