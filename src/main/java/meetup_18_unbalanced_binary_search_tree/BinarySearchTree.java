package meetup_18_unbalanced_binary_search_tree;

import meetup_06_stack_queue_dynamic_array.adt.DynamicList;

/**
 * <p>
 * Binary Search Tree.
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_tree">Wikipedia - Binary search tree</a>,
 * <a href="http://visualgo.net/bst.html">Visualgo - Binary search tree</a>
 */
public interface BinarySearchTree<E extends Comparable<E>> {

    boolean insert(E value);

    boolean contains(E value);

    void remove(E value);

    E min();

    E max();

    DynamicList<E> toList();

    int size();

    boolean isEmpty();

}
