package uk.ac.standrews.cs.cs2001.w08.test;

import org.junit.Before;
import org.junit.Test;
import uk.ac.standrews.cs.cs2001.w08.common.AbstractFactoryClient;
import uk.ac.standrews.cs.cs2001.w08.common.StackEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.StackOverflowException;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IDoubleStack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Tests array collection implementation.
 */
public class ArrayDoubleStackTests extends AbstractFactoryClient {

    /**
     * The default maximum size for the {@link ArrayDoubleStackTests#doubleStack}.
     */
    protected static final int DEFAULT_MAX_SIZE = 10;

    /**
     * The {@link IDoubleStack} instance used in these tests.
     */
    protected IDoubleStack doubleStack;

    /**
     * Re-instantiate the {@link ArrayDoubleStackTests#doubleStack} field before each test.
     */
    @Before
    public void setUp() {
        doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
    }

    /**
     * Tests that the factory constructs a non-null double stack.
     */
    @Test
    public void factoryReturnsNonNullDoubleStackObject() {
        assertTrue("Failure: IFactory.makeDoubleStack returns null, expected non-null IDoubleStack object", doubleStack != null);
    }

    /**
     * Tests that each stack created is not null.
     */
    @Test
    public void getEitherStackReturnsNonNull() {
        assertNotNull(doubleStack.getFirstStack());
        assertNotNull(doubleStack.getSecondStack());
    }

    /**
     * Tests to see that the {@link IDoubleStack#isFull()} method
     * correctly recognizes when the ADT is full.
     */
    @Test
    public void isFullTest() {

        assertFalse(doubleStack.isFull());

        for (int i = 0; i < DEFAULT_MAX_SIZE; i++) {
            try {
                doubleStack.getFirstStack().push(i);
            }
            catch (StackOverflowException e) {
                fail(EXCEPTION_NOT_EXPECTED + e);
            }
        }
        assertTrue(doubleStack.isFull());

        try {
            doubleStack.getFirstStack().pop();
        }
        catch (StackEmptyException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }
        assertFalse(doubleStack.isFull());

    }

}
