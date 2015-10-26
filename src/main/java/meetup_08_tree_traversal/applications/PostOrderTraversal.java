package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;


/**
 * <h2>145 Binary Tree Postorder Traversal</h2>
 * <p>
 * For example:<br />
 * Given binary tree,
 * <pre><code>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </code></pre>
 * return <code>[3,2,1]</code>.
 * </p>
 * <p>
 * <b>Note:</b> Recursive solution is trivial, could you do it iteratively?
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">Binary Tree Postorder Traversal</a>
 */
public interface PostOrderTraversal<E> {

    DynamicList<E> postOrderTraversal(TreeNode<E> root);

}
