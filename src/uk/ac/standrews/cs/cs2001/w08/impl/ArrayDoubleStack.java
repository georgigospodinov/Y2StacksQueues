package uk.ac.standrews.cs.cs2001.w08.impl;

import uk.ac.standrews.cs.cs2001.w08.interfaces.IDoubleStack;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IStack;

/**
 * An array based implementation of the {@link IDoubleStack} interface.
 *
 * @author 150009974
 * @version 1.0
 */
class ArrayDoubleStack implements IDoubleStack {

    /**
     * The amount by which each {@link ArrayStack#topIndex} is changed when elements are added and removed.
     * Positive one for the {@link ArrayDoubleStack#firstStack} and negative one for the {@link ArrayDoubleStack#secondStack}.
     */
    private static final int STEP = 1;

    /**
     * The maximum number of elements this {@link ArrayDoubleStack} can hold.
     */
    private int maxSize;

    /**
     * A reference to the first {@link ArrayStack} part of this ADT.
     */
    private ArrayStack firstStack;

    /**
     * A reference to the second {@link ArrayStack} part of this ADT.
     */
    private ArrayStack secondStack;

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
     * Package-private constructor used by the {@link Factory} instance.
     * Creates an array that is passed to the {@link ArrayStack#ArrayStack(ArrayDoubleStack, Object[], int, int)}
     * constructor calls so that both stacks occupy the same space.
     *
     * @param maxSize the maximum number of elements this {@link ArrayDoubleStack} can hold
     */
    ArrayDoubleStack(int maxSize) {
        this.maxSize = maxSize;
        Object[] arr = new Object[maxSize];
        firstStack = new ArrayStack(this, arr, 0, +STEP);
        secondStack = new ArrayStack(this, arr, maxSize - 1, -STEP);
    }

}
