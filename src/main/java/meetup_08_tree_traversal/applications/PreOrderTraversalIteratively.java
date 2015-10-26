package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;


public class PreOrderTraversalIteratively<E> implements PreOrderTraversal<E> {

    @Override
    public DynamicList<E> preOrderTraversal(TreeNode<E> root) {
        DynamicList<E> traversal = new ArrayDynamicList<>();

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
