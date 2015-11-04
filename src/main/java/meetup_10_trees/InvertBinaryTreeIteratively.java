package meetup_10_trees;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_08_tree_traversal.adt.TreeNode;

public class InvertBinaryTreeIteratively<E> implements InvertBinaryTree<E> {

    @Override
    public TreeNode<E> invertTree(TreeNode<E> root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode<E>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode<E> current = queue.dequeue();

            swapChildren(current);

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }

        return root;
    }

    private void swapChildren(TreeNode<E> current) {
        TreeNode<E> tmp = current.getLeft();
        current.setLeft(current.getRight());
        current.setRight(tmp);
    }

}
