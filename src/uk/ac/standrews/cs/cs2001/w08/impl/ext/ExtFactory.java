package uk.ac.standrews.cs.cs2001.w08.impl.ext;

import uk.ac.standrews.cs.cs2001.w08.interfaces.IDoubleStack;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IFactory;
import uk.ac.standrews.cs.cs2001.w08.interfaces.IPriorityQueue;

/**
 * This is a factory which creates instances of the extension classes.
 *
 * @author 150009974
 * @version 1.0
 */
public final class ExtFactory implements IFactory {

    private static IFactory factoryInstance = null;

    private ExtFactory() {

    }

    /**
     * Method which returns an instance of the singleton Factory class.
     *
     * @return the instance of the ExtFactory
     */
    public static IFactory getInstance() {
        if (factoryInstance == null) {
            factoryInstance = new ExtFactory();
        }
        return factoryInstance;
    }

    @Override
    public IDoubleStack makeDoubleStack(int maxSize) {
        return new LinkedDoubleStack(maxSize);
    }

    @Override
    public IPriorityQueue makePriorityQueue(int maxSize) {
        return new ListPriorityQueue(maxSize);
    }

}
