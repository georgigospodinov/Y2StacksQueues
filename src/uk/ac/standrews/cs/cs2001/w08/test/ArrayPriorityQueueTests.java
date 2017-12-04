package uk.ac.standrews.cs.cs2001.w08.test;

import org.junit.Before;
import org.junit.Test;

import uk.ac.standrews.cs.cs2001.w08.common.AbstractFactoryClient;
import uk.ac.standrews.cs.cs2001.w08.common.QueueEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.QueueFullException;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IPriorityQueue;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests priority queue implementation.
 */
public class ArrayPriorityQueueTests extends AbstractFactoryClient {

    /**
     * The default maximum size for the {@link ArrayPriorityQueueTests#priorityQueue}.
     */
    protected static final int DEFAULT_MAX_SIZE = 10;

    /**
     * The {@link IPriorityQueue} instance used in these tests.
     */
    protected IPriorityQueue priorityQueue;

    /**
     * Re-instantiate the {@link ArrayPriorityQueueTests#priorityQueue} instance before each test.
     */
    @Before
    public void setUp() {
        priorityQueue = getFactory().makePriorityQueue(DEFAULT_MAX_SIZE);
    }

    /**
     * Tests that the factory constructs a non-null priority queue.
     */
    @Test
    public void factoryReturnsNonNullDoubleStackObject() {
        assertTrue("Failure: IFactory.makePriorityQueue returns null, expected non-null IPriorityQueue object", priorityQueue != null);
    }

    /**
     * Tests to see that the {@link IPriorityQueue#enqueue(Comparable)} method
     * correctly adds a new element when there is space for it.
     */
    @Test
    public void enqueueAddsElement() {

        try {
            priorityQueue.enqueue(10);
            priorityQueue.enqueue(null);
        }
        catch (QueueFullException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

        assertEquals(1, priorityQueue.size());
        assertFalse(priorityQueue.isEmpty());

    }

    /**
     * Tests to see that the {@link IPriorityQueue#enqueue(Comparable)} method
     * throws the appropriate exception when the {@link IPriorityQueue} is full.
     *
     * @throws QueueFullException if the queue is full
     */
    @Test(expected = QueueFullException.class)
    public void enqueueTooManyThrowsException() throws QueueFullException {

        for (int i = 0; i < DEFAULT_MAX_SIZE; i++) {
            try {
                priorityQueue.enqueue(i);
            }
            catch (QueueFullException e) {
                fail(EXCEPTION_NOT_EXPECTED + e);
            }
        }

        priorityQueue.enqueue(DEFAULT_MAX_SIZE);

    }

    /**
     * Tests the functionality of the {@link IPriorityQueue#size()} method.
     */
    @Test
    public void sizeTest() {
        try {
            assertEquals(0, priorityQueue.size());

            priorityQueue.enqueue(1);
            assertEquals(1, priorityQueue.size());

            priorityQueue.enqueue(10);
            assertEquals(2, priorityQueue.size());
        }
        catch (QueueFullException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }
    }

    /**
     * Tests the functionality of the {@link IPriorityQueue#isEmpty()} method.
     */
    @Test
    public void isEmptyTest() {
        try {
            assertTrue(priorityQueue.isEmpty());

            priorityQueue.enqueue(1);
            assertFalse(priorityQueue.isEmpty());

            priorityQueue.dequeue();
            assertTrue(priorityQueue.isEmpty());
        }
        catch (QueueFullException | QueueEmptyException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }
    }

    /**
     * Tests the functionality of the {@link IPriorityQueue#clear()} method.
     */
    @Test
    public void clearTest() {
        try {
            assertTrue(priorityQueue.isEmpty());

            priorityQueue.enqueue(1);
            priorityQueue.enqueue(2);
            assertFalse(priorityQueue.isEmpty());

            priorityQueue.clear();
            assertTrue(priorityQueue.isEmpty());
        }
        catch (QueueFullException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }
    }

    /**
     * Tests to see that the {@link IPriorityQueue#dequeue()} method
     * correctly removes an element from the {@link IPriorityQueue}.
     */
    @Test
    public void dequeueRemovesElement() {
        try {
            priorityQueue.enqueue(1);
            assertEquals(1, priorityQueue.size());

            assertEquals(1, priorityQueue.dequeue());
            assertTrue(priorityQueue.isEmpty());
        }
        catch (QueueFullException | QueueEmptyException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }
    }

    /**
     * Tests to see that the {@link IPriorityQueue#dequeue()} method
     * correctly removes the largest element from the {@link IPriorityQueue}.
     */
    @Test
    public void dequeueRemovesLargestElement() {
        try {
            priorityQueue.enqueue(1);
            priorityQueue.enqueue(50);
            priorityQueue.enqueue(2);

            assertEquals(3, priorityQueue.size());

            assertEquals(50, priorityQueue.dequeue());

            assertEquals(2, priorityQueue.size());
        }
        catch (QueueEmptyException | QueueFullException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }
    }

    /**
     * Tests to see that the {@link IPriorityQueue#dequeue()} method
     * throws the appropriate exception when the {@link IPriorityQueue} is empty.
     *
     * @throws QueueEmptyException if the queue is empty
     */
    @Test(expected = QueueEmptyException.class)
    public void dequeueEmptyQueue() throws QueueEmptyException {
        priorityQueue.dequeue();
    }

}
