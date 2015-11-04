package meetup_10_trees;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">199 Binary Tree Right Side View</a>
 */
public class BinaryTreeRightSideView<E> {

    public DynamicList<E> rightSideView(TreeNode<E> root) {
        if (root == null) {
            return new ArrayDynamicList<>();
        }

        DynamicList<E> rightView = new ArrayDynamicList<>();

        Queue<TreeNode<E>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            rightView.add(queue.peek().getValue());
            int currentLevelNodeNumber = queue.size();

            for (int i = 0; i < currentLevelNodeNumber; i++) {
                TreeNode<E> current = queue.dequeue();

                if (current.getRight() != null) {
                    queue.enqueue(current.getRight());
                }

                if (current.getLeft() != null) {
                    queue.enqueue(current.getLeft());
                }
            }
        }

        return rightView;
    }

}
