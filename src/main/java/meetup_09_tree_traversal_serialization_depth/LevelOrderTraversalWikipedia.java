package meetup_09_tree_traversal_serialization_depth;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;

public class LevelOrderTraversalWikipedia<E> {

    public DynamicList<E> levelOrderTraversal(TreeNode<E> root) {
        DynamicList<E> traversal = new ArrayDynamicList<>();

        if (root == null) {
            return traversal;
        }

        Queue<TreeNode<E>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode<E> current = queue.dequeue();
            traversal.add(current.getValue());

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }

        return traversal;
    }

}
