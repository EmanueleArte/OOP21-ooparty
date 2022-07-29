package utils;

/**
 * This interface models a pair of elements.
 * 
 * @param <X> the left element
 * @param <Y> the right element
 */
public interface Pair<X, Y> {

    /**
     * Getter for the left element.
     * 
     * @return the left element
     */
    X getX();

    /**
     * Getter for the right element.
     * 
     * @return the right element
     */
    Y getY();

}
