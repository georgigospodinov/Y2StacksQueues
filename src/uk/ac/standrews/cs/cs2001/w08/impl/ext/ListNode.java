package uk.ac.standrews.cs.cs2001.w08.impl.ext;

/**
 * Represents a list node used in {@link ListPriorityQueue}.
 *
 * @author 150009974
 * @version 1.0
 */
class ListNode {

    /**
     * The element this {@link ListNode} holds.
     */
    Comparable element;

    /**
     * A reference to the next node.
     */
    ListNode next;

    /**
     * Package-private constructor used by the {@link ListPriorityQueue} to add new elements to itself.
     *
     * @param element the element this {@link ListNode} should hold.
     */
    ListNode(Comparable element) {
        this.element = element;
        this.next = null;
    }
}
