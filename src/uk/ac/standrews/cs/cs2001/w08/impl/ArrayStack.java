package uk.ac.standrews.cs.cs2001.w08.impl;

import uk.ac.standrews.cs.cs2001.w08.common.StackEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.StackOverflowException;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IStack;

/**
 * An array based implementation of the {@link IStack} interface.
 *
 * @author 150009974
 * @version 1.0
 */
class ArrayStack implements IStack {

    /**
     * A reference to the {@link ArrayDoubleStack} instance which created this object.
     */
    private ArrayDoubleStack parent;

    /**
     * A reference to the array shared with another {@link ArrayStack} instance.
     */
    private Object[] arr;

    /**
     * The current size of this {@link ArrayStack} instance.
     */
    private int size;

    /**
     * The step with which the {@link ArrayStack#topIndex} is changed.
     * {@link ArrayStack#push(Object)} adds this value to the {@link ArrayStack#topIndex} and
     * {@link ArrayStack#pop()} subtracts this value from the {@link ArrayStack#topIndex}.
     * This value should be positive one for the first stack
     * and negative one for the second stack.
     */
    private int step;

    /**
     * The current index of the top element.
     */
    private int topIndex;

    @Override
    public void push(Object element) throws StackOverflowException {

        if (parent.isFull()) {
            throw new StackOverflowException();
        }

        if (element == null) {
            return;
        }

        // The index after the top.
        int nextIndex = topIndex + step;

        arr[nextIndex] = element;
        size++;
        topIndex = nextIndex;
    }

    @Override
    public Object pop() throws StackEmptyException {

        Object topElement = top();

        arr[topIndex] = null;
        topIndex -= step;
        size--;

        return topElement;
    }

    @Override
    public Object top() throws StackEmptyException {

        if (size == 0) {
            throw new StackEmptyException();
        }

        return arr[topIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        while (!this.isEmpty()) {
            try {
                this.pop();
            }
            catch (StackEmptyException ignored) {
                // This exception cannot be thrown because of the while condition.
            }
        }
    }

    /**
     * Package-private constructor for the {@link ArrayDoubleStack} class.
     *
     * @param parent the {@link ArrayDoubleStack} instance which created this {@link ArrayStack}.
     * @param arr    the array this instance should have access to
     * @param bottom the index in that array where this stack should start putting its elements
     * @param step   the amount by which the {@link ArrayStack#topIndex} is moved when an element is added
     *               this is 1 for the {@link ArrayDoubleStack#firstStack}
     *               and -1 for the {@link ArrayDoubleStack#secondStack}
     */
    ArrayStack(ArrayDoubleStack parent, Object[] arr, int bottom, int step) {
        this.parent = parent;
        this.arr = arr;
        this.size = 0;
        this.step = step;
        this.topIndex = bottom - step;
    }

}
