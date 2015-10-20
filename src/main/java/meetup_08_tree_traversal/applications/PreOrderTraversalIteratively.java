package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalIteratively<E> implements PreOrderTraversal<E> {

    @Override
    public List<E> preOrderTraversal(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        Stack<TreeNode<E>> stack = new LinkedStack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            traversal.add(current.getValue());

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }

        return traversal;
    }

}
