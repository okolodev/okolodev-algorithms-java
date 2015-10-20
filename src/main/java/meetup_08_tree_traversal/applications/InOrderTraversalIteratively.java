package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class InOrderTraversalIteratively<E> implements InOrderTraversal<E> {

    @Override
    public List<E> inOrderTraversal(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        Stack<TreeNode<E>> stack = new LinkedStack<>();
        TreeNode<E> current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                traversal.add(current.getValue());
                current = current.getRight();
            }
        }

        return traversal;
    }

    public List<E> inOrderTraversalFirstTry(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        IdentityHashMap<TreeNode<E>, Boolean> processed = new IdentityHashMap<>();
        Stack<TreeNode<E>> stack = new LinkedStack<>();

        if (root.getRight() != null) {
            stack.push(root.getRight());
            processed.put(root.getRight(), false);
        }

        stack.push(root);
        processed.put(root, true);

        if (root.getLeft() != null) {
            stack.push(root.getLeft());
            processed.put(root.getLeft(), false);
        }

        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();

            if (processed.get(current)) {
                traversal.add(current.getValue());
            } else {
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                    processed.put(current.getRight(), false);
                }

                stack.push(current);
                processed.put(current, true);

                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                    processed.put(current.getLeft(), false);
                }
            }
        }

        return traversal;
    }

}
