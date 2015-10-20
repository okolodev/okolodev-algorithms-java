package meetup_08_tree_traversal.applications;

import meetup_08_tree_traversal.adt.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversalRecursively<E> implements InOrderTraversal<E> {

    @Override
    public List<E> inOrderTraversal(TreeNode<E> root) {
        List<E> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        inOrderTraversal(root, traversal);

        return traversal;
    }

    private void inOrderTraversal(TreeNode<E> root, List<E> traversal) {
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
