package uk.ac.standrews.cs.cs2001.w08.impl.ext;

import uk.ac.standrews.cs.cs2001.w08.common.QueueEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.QueueFullException;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IPriorityQueue;

/**
 * A linked list based implementation of the {@link IPriorityQueue} interface.
 *
 * @author 150009974
 * @version 1.2
 */
class ListPriorityQueue implements IPriorityQueue {

    /**
     * A reference to the front {@link ListNode} of the {@link ListPriorityQueue}.
     */
    private ListNode front;

    /**
     * A reference to the back {@link ListNode} of the {@link ListPriorityQueue}.
     * It is used to quickly add elements.
     */
    private ListNode back;

    /**
     * The current size of the {@link ListPriorityQueue}.
     */
    private int size;

    /**
     * The maximum size this {@link ListPriorityQueue} should be able to reach.
     */
    private int maxSize;

    @Override
    public void enqueue(Comparable element) throws QueueFullException {

        if (size >= maxSize) {
            throw new QueueFullException();
        }

        if (element == null) {
            return;
        }

        if (size == 0) {
            front = new ListNode(element);
            back = front;
            size++;
            return;
        }

        back.next = new ListNode(element);
        back = back.next;
        size++;

    }

    @Override
    public Comparable dequeue() throws QueueEmptyException {

        if (size == 0) {
            throw new QueueEmptyException();
        }

        ListNode predecessorOfLargest = null;
        Comparable largest = front.element;

        ListNode previous = front;
        ListNode current = front.next;

        while (current != null) {

            if (largest.compareTo(current.element) < 0) { // Is there a new largest?
                largest = current.element;
                predecessorOfLargest = previous;
            }

            previous = current;
            current = current.next;
        }

        if (predecessorOfLargest == null) { // The front element is the largest (no predecessor).
            front = front.next;
        }
        else { // Otherwise the largest element has a predecessor.
            predecessorOfLargest.next = predecessorOfLargest.next.next;
        }
        size--;
        return largest;

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
        front = null;
        back = null;
        size = 0;
    }

    /**
     * Package-private constructor used by the {@link ExtFactory} instance.
     *
     * @param maxSize the maximum amount of elements this queue should hold
     */
    ListPriorityQueue(int maxSize) {
        this.front = null;
        this.back = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

}
