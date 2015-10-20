package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;

import java.util.List;

/**
 * <h2>144 Binary Tree Preorder Traversal</h2>
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * </p>
 * <p>
 * For example:<br />
 * Given binary tree {1,#,2,3},
 * <pre><code>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </code></pre>
 * return <code>[1,2,3]</code>.
 * </p>
 * <p>
 * <b>Note:</b> Recursive solution is trivial, could you do it iteratively?
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">144 Binary Tree Preorder Traversal</a>
 */
public interface PreOrderTraversal<E> {

    List<E> preOrderTraversal(TreeNode<E> root);

}
