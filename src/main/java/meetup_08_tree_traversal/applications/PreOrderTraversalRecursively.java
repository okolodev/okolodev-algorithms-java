package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;


public class PreOrderTraversalRecursively<E> implements PreOrderTraversal<E> {

    @Override
    public DynamicList<E> preOrderTraversal(TreeNode<E> root) {
        DynamicList<E> traversal = new ArrayDynamicList<>();

        if (root == null) {
            return traversal;
        }

        preOrderTraversal(root, traversal);

        return traversal;
    }

    private void preOrderTraversal(TreeNode<E> root, DynamicList<E> traversal) {
        if (root == null) {
            return;
        }

        traversal.add(root.getValue());

        if (root.getLeft() != null) {
            preOrderTraversal(root.getLeft(), traversal);
        }

        if (root.getRight() != null) {
            preOrderTraversal(root.getRight(), traversal);
        }
    }

}
