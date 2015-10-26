package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;


public class PostOrderTraversalRecursively<E> implements PostOrderTraversal<E> {

    @Override
    public DynamicList<E> postOrderTraversal(TreeNode<E> root) {
        DynamicList<E> traversal = new ArrayDynamicList<>();

        if (root == null) {
            return traversal;
        }

        postOrderTraversal(root, traversal);

        return traversal;

    }

    private void postOrderTraversal(TreeNode<E> root, DynamicList<E> traversal) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            postOrderTraversal(root.getLeft(), traversal);
        }

        if (root.getRight() != null) {
            postOrderTraversal(root.getRight(), traversal);
        }

        traversal.add(root.getValue());
    }

}
