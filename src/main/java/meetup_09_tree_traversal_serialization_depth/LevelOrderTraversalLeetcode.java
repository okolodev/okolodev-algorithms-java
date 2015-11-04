package meetup_09_tree_traversal_serialization_depth;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 */
public class LevelOrderTraversalLeetcode<E> {

    public DynamicList<DynamicList<E>> levelOrderTraversal(TreeNode<E> root) {
        DynamicList<DynamicList<E>> traversal = new ArrayDynamicList<>();

        if (root == null) {
            return traversal;
        }

        Queue<TreeNode<E>> queue = new LinkedQueue<>();

        queue.enqueue(root);

        while (!queue.isEmpty()) {
            DynamicList<E> currentLevelTraversal = new ArrayDynamicList<>();
            int currentLevelNodeNumber = queue.size();

            for (int i = 0; i < currentLevelNodeNumber; i++) {
                TreeNode<E> current = queue.dequeue();

                currentLevelTraversal.add(current.getValue());

                if (current.getLeft() != null) {
                    queue.enqueue(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.enqueue(current.getRight());
                }
            }

            traversal.add(currentLevelTraversal);
        }

        return traversal;
    }

}
