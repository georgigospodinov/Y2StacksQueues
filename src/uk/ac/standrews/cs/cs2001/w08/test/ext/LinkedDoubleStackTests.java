package uk.ac.standrews.cs.cs2001.w08.test.ext;

import uk.ac.standrews.cs.cs2001.w08.impl.ext.ExtFactory;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IDoubleStack;
import uk.ac.standrews.cs.cs2001.w08.test.ArrayDoubleStackTests;

/**
 * Tests the implementation of the {@link IDoubleStack} interface, provided by the {@link ExtFactory} class.
 *
 * @author 150009974
 * @version 1.0
 */
public class LinkedDoubleStackTests extends ArrayDoubleStackTests {

    @Override
    public void setUp() {
        doubleStack = ExtFactory.getInstance().makeDoubleStack(DEFAULT_MAX_SIZE);
    }
}
