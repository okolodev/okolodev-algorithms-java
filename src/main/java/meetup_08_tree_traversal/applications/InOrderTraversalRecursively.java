package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;


public class InOrderTraversalRecursively<E> implements InOrderTraversal<E> {

    @Override
    public DynamicList<E> inOrderTraversal(TreeNode<E> root) {
        DynamicList<E> traversal = new ArrayDynamicList<>();

        if (root == null) {
            return traversal;
        }

        inOrderTraversal(root, traversal);

        return traversal;
    }

    private void inOrderTraversal(TreeNode<E> root, DynamicList<E> traversal) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft(), traversal);
        }

        traversal.add(root.getValue());

        if (root.getRight() != null) {
            inOrderTraversal(root.getRight(), traversal);
        }
    }

}
