package uk.ac.standrews.cs.cs2001.w08.impl.ext;

import uk.ac.standrews.cs.cs2001.w08.common.StackEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.StackOverflowException;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IStack;

/**
 * An linked based implementation of the {@link IStack} interface.
 * Has a pointer to the top node. Each node has a pointer to the one below it.
 *
 * @author 150009974
 * @version 1.1
 */
class LinkedStack implements IStack {

    /**
     * A reference to the {@link LinkedDoubleStack} instance which created this {@link LinkedStack}.
     */
    private LinkedDoubleStack parent;

    /**
     * The current size of this {@link LinkedStack}.
     */
    private int size;

    /**
     * A reference to the top {@link LinkNode} of this {@link LinkedStack}.
     */
    private LinkNode top;

    @Override
    public void push(Object element) throws StackOverflowException {

        if (parent.isFull()) {
            throw new StackOverflowException();
        }

        if (element == null) {
            return;
        }

        // Encapsulate the new element.
        LinkNode toAdd = new LinkNode(element);

        // Put it on top of the stack.
        toAdd.below = top;

        // Set it as the new top.
        top = toAdd;

        size++;

    }

    @Override
    public Object pop() throws StackEmptyException {

        if (size == 0) {
            throw new StackEmptyException();
        }

        Object topElement = top.element;

        // Move the top one level down.
        top = top.below;
        size--;

        return topElement;
    }

    @Override
    public Object top() throws StackEmptyException {

        if (top == null) {
            throw new StackEmptyException();
        }

        return top.element;

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
        size = 0;
        top = null;
    }

    /**
     * Package-private constructor used by the {@link LinkedDoubleStack} to instantiate its two stacks.
     *
     * @param parent the {@link LinkedDoubleStack} instance which created this {@link LinkedStack}.
     */
    LinkedStack(LinkedDoubleStack parent) {
        size = 0;
        top = null;
        this.parent = parent;
    }

}
