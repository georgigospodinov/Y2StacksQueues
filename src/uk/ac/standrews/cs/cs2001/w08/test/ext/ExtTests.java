package uk.ac.standrews.cs.cs2001.w08.test.ext;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * This is a JUnit test suite for the
 * {@link LinkedDoubleStackTests}, {@link LinkedStackTests}, and {@link ListPriorityQueueTests}.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LinkedDoubleStackTests.class,
        ListPriorityQueueTests.class,
        LinkedStackTests.class
})
public class ExtTests {
}
