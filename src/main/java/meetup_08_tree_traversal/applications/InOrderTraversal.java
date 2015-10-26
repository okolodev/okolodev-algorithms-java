package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;


/**
 * <h2>94 Binary Tree Inorder Traversal</h2>
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:<br />
 * Given binary tree <code>{1,#,2,3}</code>,
 * <pre><code>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </code></pre>
 * return <code>[1,3,2]</code>.
 * </p>
 * <p>
 * <b>Note:</b> Recursive solution is trivial, could you do it iteratively?
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94 Binary Tree Inorder Traversal</a>
 */
public interface InOrderTraversal<E> {

    DynamicList<E> inOrderTraversal(TreeNode<E> root);

}
