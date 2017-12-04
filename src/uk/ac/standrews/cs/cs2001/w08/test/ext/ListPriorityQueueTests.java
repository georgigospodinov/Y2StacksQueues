package uk.ac.standrews.cs.cs2001.w08.test.ext;

import uk.ac.standrews.cs.cs2001.w08.impl.ext.ExtFactory;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IPriorityQueue;
import uk.ac.standrews.cs.cs2001.w08.test.ArrayPriorityQueueTests;

/**
 * Tests the implementation of the {@link IPriorityQueue} interface, provided by the {@link ExtFactory} class.
 *
 * @author 150009974
 * @version 1.0
 */
public class ListPriorityQueueTests extends ArrayPriorityQueueTests {

    @Override
    public void setUp() {
        priorityQueue = ExtFactory.getInstance().makePriorityQueue(DEFAULT_MAX_SIZE);
    }
}
