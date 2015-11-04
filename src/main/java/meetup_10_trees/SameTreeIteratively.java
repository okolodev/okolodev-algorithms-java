package meetup_10_trees;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_08_tree_traversal.adt.TreeNode;

import java.util.Objects;

public class SameTreeIteratively<E> implements SameTree<E> {

    @Override
    public boolean isSameTree(TreeNode<E> firstTree,
                              TreeNode<E> secondTree) {
        if (firstTree == null && secondTree == null) {
            return true;
        } else if (firstTree == null ^ secondTree == null) {
            return false;
        }

        Queue<TreeNode<E>> firstQueue = new LinkedQueue<>();
        Queue<TreeNode<E>> secondQueue = new LinkedQueue<>();

        firstQueue.enqueue(firstTree);
        secondQueue.enqueue(secondTree);

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            TreeNode<E> firstCurrent = firstQueue.dequeue();
            TreeNode<E> secondCurrent = secondQueue.dequeue();

            if (!Objects.equals(firstCurrent.getValue(), secondCurrent.getValue())) {
                return false;
            }

            TreeNode<E> firstLeft = firstCurrent.getLeft();
            TreeNode<E> firstRight = firstCurrent.getRight();

            TreeNode<E> secondLeft = secondCurrent.getLeft();
            TreeNode<E> secondRight = secondCurrent.getRight();

            if (firstLeft == null ^ secondLeft == null) {
                return false;
            }

            if (firstRight == null ^ secondRight == null) {
                return false;
            }

            enqueueIfNotNull(firstQueue, firstLeft);
            enqueueIfNotNull(firstQueue, firstRight);

            enqueueIfNotNull(secondQueue, secondLeft);
            enqueueIfNotNull(secondQueue, secondRight);
        }

        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }

    private void enqueueIfNotNull(Queue<TreeNode<E>> queue, TreeNode<E> child) {
        if (child != null) {
            queue.enqueue(child);
        }
    }

}
