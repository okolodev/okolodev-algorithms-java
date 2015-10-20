package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalRecursively<E> implements PreOrderTraversal<E> {

    @Override
    public List<E> preOrderTraversal(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        preOrderTraversal(root, traversal);

        return traversal;
    }

    private void preOrderTraversal(TreeNode<E> root, List<E> traversal) {
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
