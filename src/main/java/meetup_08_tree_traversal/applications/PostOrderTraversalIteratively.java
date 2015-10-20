package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversalIteratively<E> implements PostOrderTraversal<E> {

    @Override
    public List<E> postOrderTraversal(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        Stack<TreeNode<E>> stack = new LinkedStack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            traversal.add(current.getValue());

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }

        reverse(traversal);

        return traversal;
    }

    private void reverse(List<E> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            swap(list, i, list.size() - 1 - i);
        }
    }

    private void swap(List<E> list, int i, int j) {
        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

}
