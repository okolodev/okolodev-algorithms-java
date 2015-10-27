package meetup_09_tree_traversal_serialization_depth;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_08_tree_traversal.adt.TreeNode;

public class TreeMaximumDepthIteratively<E> implements TreeMaximumDepth<E> {

    @Override
    public int maxDepth(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode<E>> currentLevel = new LinkedQueue<>();
        Queue<TreeNode<E>> nextLevel = new LinkedQueue<>();

        currentLevel.enqueue(root);

        int depth = 0;

        while (!currentLevel.isEmpty()) {
            depth++;

            while (!currentLevel.isEmpty()) {
                TreeNode<E> current = currentLevel.dequeue();

                if (current.getLeft() != null) {
                    nextLevel.enqueue(current.getLeft());
                }

                if (current.getRight() != null) {
                    nextLevel.enqueue(current.getRight());
                }
            }

            currentLevel = nextLevel;
            nextLevel = new LinkedQueue<>();
        }

        return depth;
    }

}
