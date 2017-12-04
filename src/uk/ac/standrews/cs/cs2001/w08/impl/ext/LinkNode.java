package uk.ac.standrews.cs.cs2001.w08.impl.ext;

/**
 * Represents a node used in {@link LinkedStack}.
 *
 * @author 150009974
 * @version 1.0
 */
class LinkNode {

    /**
     * The element this {@link LinkNode} should hold.
     */
    Object element;

    /**
     * A reference to the element below it.
     */
    LinkNode below;

    /**
     * Package-private constructor used by the {@link LinkedStack} to add new elements to itself.
     *
     * @param element the element this {@link LinkNode} should hold
     */
    LinkNode(Object element) {
        this.element = element;
        this.below = null;
    }

}
