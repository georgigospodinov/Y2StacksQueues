package uk.ac.standrews.cs.cs2001.w08.test;

import org.junit.Before;
import org.junit.Test;
import uk.ac.standrews.cs.cs2001.w08.common.AbstractFactoryClient;
import uk.ac.standrews.cs.cs2001.w08.common.StackEmptyException;
import uk.ac.standrews.cs.cs2001.w08.common.StackOverflowException;
import uk.ac.standrews.cs.cs2001.w08.impl.Factory;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IDoubleStack;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IStack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the implementation of the {@link IStack} interface, provided by the {@link Factory} class.
 *
 * @author 150009974
 * @version 1.0
 */
public class ArrayStackTests extends AbstractFactoryClient {

    /**
     * The default maximum size for the {@link ArrayStackTests#doubleStack}.
     */
    protected static final int DEFAULT_MAX_SIZE = 10;

    /**
     * The {@link IDoubleStack} instance used as a parent for these tests.
     */
    protected IDoubleStack doubleStack;

    /**
     * Re-instantiate the {@link ArrayStackTests#doubleStack} field before each test.
     */
    @Before
    public void setUp() {
        doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
    }

    /**
     * Tests the functionality of the {@link IStack#clear()} method.
     */
    @Test
    public void clearTest() {

        IStack first = doubleStack.getFirstStack();

        try {
            first.push(1);
            first.push(1);
        }
        catch (StackOverflowException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

        assertEquals(2, first.size());
        first.clear();
        assertEquals(0, first.size());

    }

    /**
     * Tests the functionality of the {@link IStack#isEmpty()} method.
     */
    @Test
    public void isEmptyTest() {

        IStack first = doubleStack.getFirstStack();
        assertTrue(first.isEmpty());
        try {
            first.push(1);
            assertFalse(first.isEmpty());
            first.pop();
            assertTrue(first.isEmpty());
        }
        catch (StackEmptyException | StackOverflowException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

    }

    /**
     * Tests the functionality of the {@link IStack#size()} method.
     */
    @Test
    public void sizeTest() {

        IStack first = doubleStack.getFirstStack();
        assertEquals(0, first.size());
        try {
            first.push(1);
            assertEquals(1, first.size());
            first.pop();
            assertEquals(0, first.size());
        }
        catch (StackEmptyException | StackOverflowException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

    }

    /**
     * Tests to see that the {@link IStack#top()} method
     * correctly returns the top element when there is one.
     */
    @Test
    public void topSuccessfully() {

        IStack first = doubleStack.getFirstStack();
        try {

            first.push(1);
            first.push(3);
            assertEquals(3, first.top());
        }
        catch (StackOverflowException | StackEmptyException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

    }

    /**
     * Tests to see that the {@link IStack#top()} method
     * throws the appropriate exception when the {@link IStack} is empty.
     *
     * @throws StackEmptyException if the stack is empty
     */
    @Test(expected = StackEmptyException.class)
    public void topStackEmpty() throws StackEmptyException {
        doubleStack.getFirstStack().top();
    }

    /**
     * Tests to see that the {@link IStack#pop()} method
     * correctly returns and removes the top element when there is one.
     */
    @Test
    public void popSuccessfully() {

        IStack first = doubleStack.getFirstStack();
        try {
            first.push(1);
            first.push(3);

            assertEquals(2, first.size());
            assertEquals(3, first.pop());
            assertEquals(1, first.size());
        }
        catch (StackOverflowException | StackEmptyException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

    }

    /**
     * Tests to see that the {@link IStack#pop()} method
     * throws the appropriate exception when the {@link IStack} is empty.
     *
     * @throws StackEmptyException if the stack is empty
     */
    @Test(expected = StackEmptyException.class)
    public void popStackEmpty() throws StackEmptyException {
        doubleStack.getFirstStack().pop();
    }

    /**
     * Tests to see that the {@link IStack#push(Object)} method
     * successfully adds a new element when there is room for it.
     */
    @Test
    public void pushSuccessfully() {

        IStack first = doubleStack.getFirstStack();

        assertTrue(first.isEmpty());

        try {
            first.push(1);
            first.push(1);
            first.push(null);
        }
        catch (StackOverflowException e) {
            fail(EXCEPTION_NOT_EXPECTED + e);
        }

        assertEquals(2, first.size());

    }

    /**
     * Tests to see that the {@link IStack#push(Object)} method
     * throws the appropriate exception when the stack is full.
     *
     * @throws StackOverflowException if the stack is full
     */
    @Test(expected = StackOverflowException.class)
    public void pushOverMaxSize() throws StackOverflowException {

        IStack first = doubleStack.getFirstStack();
        for (int i = 0; i < DEFAULT_MAX_SIZE; i++) {
            try {
                first.push(i);
            }
            catch (StackOverflowException e) {
                fail(EXCEPTION_NOT_EXPECTED + e);
            }
        }

        first.push(DEFAULT_MAX_SIZE);

    }

    /**
     * Tests to see that the {@link IStack#push(Object)} method
     * throws the appropriate exception when
     * the other stack in the {@link IDoubleStack} implementation is occupying the space.
     *
     * @throws StackOverflowException if the stack is full
     */
    @Test(expected = StackOverflowException.class)
    public void pushToSecondStack() throws StackOverflowException {

        IStack first = doubleStack.getFirstStack();
        IStack second = doubleStack.getSecondStack();
        for (int i = 0; i < DEFAULT_MAX_SIZE / 2; i++) {
            try {
                first.push(i);
                second.push(DEFAULT_MAX_SIZE - 1 - i);
            }
            catch (StackOverflowException e) {
                fail(EXCEPTION_NOT_EXPECTED + e);
            }
        }

        // This will throw the exception when the size is an even number.
        first.push(DEFAULT_MAX_SIZE / 2);

        // And this if it is an odd number.
        second.push(DEFAULT_MAX_SIZE / 2 - 1);
    }
}
