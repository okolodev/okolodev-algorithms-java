package meetup_10_trees;

import meetup_08_tree_traversal.adt.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">100 Same Tree</a>
 */
public interface SameTree<E> {

    boolean isSameTree(TreeNode<E> firstTree, TreeNode<E> secondTree);

}
