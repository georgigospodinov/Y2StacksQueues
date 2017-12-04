package uk.ac.standrews.cs.cs2001.w08.impl;

import uk.ac.standrews.cs.cs2001.w08.common.QueueEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.QueueFullException;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IPriorityQueue;

/**
 * An array based implementation of the {@link IPriorityQueue} interface.
 *
 * @author 150009974
 * @version 1.1
 */
class ArrayPriorityQueue implements IPriorityQueue {

    /**
     * The array where this {@link ArrayPriorityQueue} puts its elements.
     */
    private Comparable[] arr;

    /**
     * The current size of this {@link ArrayPriorityQueue}.
     */
    private int size;

    @Override
    public void enqueue(Comparable element) throws QueueFullException {

        if (size == arr.length) {
            throw new QueueFullException();
        }

        if (element == null) {
            return;
        }

        arr[size++] = element;

    }

    @Override
    public Comparable dequeue() throws QueueEmptyException {

        if (size == 0) {
            throw new QueueEmptyException();
        }

        // First fine the index of the largest element.
        int largestElementIndex = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i].compareTo(arr[largestElementIndex]) > 0) {
                largestElementIndex = i;
            }
        }

        Comparable largest = arr[largestElementIndex];
        size--;

        // Then sift the queue.
        for (int i = largestElementIndex; i < size; i++) {
            arr[i] = arr[i + 1];
        }

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
        arr = new Comparable[arr.length];
        size = 0;

    }

    /**
     * Package-private constructor used by the {@link Factory} instance.
     *
     * @param maxSize the maximum amount of elements this {@link ArrayPriorityQueue} can hold
     */
    ArrayPriorityQueue(int maxSize) {
        arr = new Comparable[maxSize];
        size = 0;
    }

}
