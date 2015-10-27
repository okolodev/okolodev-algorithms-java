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

        Queue<TreeNode<E>> currentLevel = new LinkedQueue<>();
        Queue<TreeNode<E>> nextLevel = new LinkedQueue<>();

        currentLevel.enqueue(root);

        while (!currentLevel.isEmpty()) {
            DynamicList<E> currentLevelTraversal = new ArrayDynamicList<>();

            while (!currentLevel.isEmpty()) {
                TreeNode<E> current = currentLevel.dequeue();

                currentLevelTraversal.add(current.getValue());

                if (current.getLeft() != null) {
                    nextLevel.enqueue(current.getLeft());
                }

                if (current.getRight() != null) {
                    nextLevel.enqueue(current.getRight());
                }
            }

            currentLevel = nextLevel;
            nextLevel = new LinkedQueue<>();

            traversal.add(currentLevelTraversal);
        }

        return traversal;
    }

}
