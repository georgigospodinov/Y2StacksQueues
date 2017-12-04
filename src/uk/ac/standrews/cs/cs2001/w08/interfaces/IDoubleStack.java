package uk.ac.standrews.cs.cs2001.w08.interfaces;

/**
 * This interface represents the double stack object.
 *
 */
public interface IDoubleStack {

    /**
     * Method which returns the first IStack object in the IDoubleStack for subsequent use with {@link IStack} operations.
     * @return the first stack in the double stack
     */
    IStack getFirstStack();

    /**
     * Method which returns the second IStack in the IDoubleStack object for subsequent use with {@link IStack} operations.
     * @return the second stack in the double stack
     */
    IStack getSecondStack();

    /**
     * Method which returns whether or not the stack has reached its maximum size.
     *
     * @return true if it is full
     */
    boolean isFull();
}
