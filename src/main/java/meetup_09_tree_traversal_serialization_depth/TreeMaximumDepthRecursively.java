package meetup_09_tree_traversal_serialization_depth;

import meetup_08_tree_traversal.adt.TreeNode;

public class TreeMaximumDepthRecursively<E> implements TreeMaximumDepth<E> {

    @Override
    public int maxDepth(TreeNode<E> root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode<E> root, int depth) {
        if (root == null) {
            return depth;
        }

        int leftDepth = maxDepth(root.getLeft(), depth);
        int rightDepth = maxDepth(root.getRight(), depth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
