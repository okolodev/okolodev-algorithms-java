package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversalRecursively<E> implements PostOrderTraversal<E> {

    @Override
    public List<E> postOrderTraversal(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        postOrderTraversal(root, traversal);

        return traversal;

    }

    private void postOrderTraversal(TreeNode<E> root, List<E> traversal) {
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
