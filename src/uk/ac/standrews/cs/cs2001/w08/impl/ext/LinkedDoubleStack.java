package uk.ac.standrews.cs.cs2001.w08.impl.ext;

import uk.ac.standrews.cs.cs2001.w08.interfaces.IDoubleStack;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IStack;

/**
 * Linked node implementation of the {@link IDoubleStack} interface.
 *
 * @author 150009974
 * @version 1.2
 */
class LinkedDoubleStack implements IDoubleStack {

    /**
     * The maximum number of elements this {@link LinkedDoubleStack} can hold.
     */
    private int maxSize;

    /**
     * A reference to the first {@link LinkedStack} part of this ADT.
     */
    private LinkedStack firstStack;

    /**
     * A reference to the second {@link LinkedStack} part of this ADT.
     */
    private LinkedStack secondStack;

    @Override
    public IStack getFirstStack() {
        return firstStack;
    }

    @Override
    public IStack getSecondStack() {
        return secondStack;
    }

    @Override
    public boolean isFull() {
        return firstStack.size() + secondStack.size() >= maxSize;
    }

    /**
     * Package-private constructor used by the {@link ExtFactory} instance.
     *
     * @param maxSize the maximum amount of elements this {@link LinkedDoubleStack} can hold
     */
    LinkedDoubleStack(int maxSize) {
        firstStack = new LinkedStack(this);
        secondStack = new LinkedStack(this);
        this.maxSize = maxSize;
    }

}
