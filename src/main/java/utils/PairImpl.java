package utils;

/**
 * Implementation of {@link Pair}.
 *
 * @param <X> the left element
 * @param <Y> the right element
 */
public class PairImpl<X, Y> implements Pair<X, Y> {

    private final X x;
    private final Y y;

    /**
     * Builder for {@link PairImpl}.
     * 
     * @param x the x of the coordinates
     * @param y the x of the coordinates
     */
    public PairImpl(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public final X getX() {
        return this.x;
    }

    @Override
    public final Y getY() {
        return this.y;
    }

}
