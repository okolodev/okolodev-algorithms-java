package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;


public class PostOrderTraversalIteratively<E> implements PostOrderTraversal<E> {

    @Override
    public DynamicList<E> postOrderTraversal(TreeNode<E> root) {
        DynamicList<E> traversal = new ArrayDynamicList<>();

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

    private void reverse(DynamicList<E> DynamicList) {
        for (int i = 0; i < DynamicList.size() / 2; i++) {
            swap(DynamicList, i, DynamicList.size() - 1 - i);
        }
    }

    private void swap(DynamicList<E> DynamicList, int i, int j) {
        E tmp = DynamicList.get(i);
        DynamicList.set(i, DynamicList.get(j));
        DynamicList.set(j, tmp);
    }

}
