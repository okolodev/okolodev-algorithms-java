package meetup_10_trees;

import meetup_08_tree_traversal.adt.TreeNode;

public class InvertBinaryTreeRecursively<E> implements InvertBinaryTree<E> {

    @Override
    public TreeNode<E> invertTree(TreeNode<E> root) {
        if (root == null) {
            return null;
        }

        swapChildren(root);

        invertTree(root.getLeft());
        invertTree(root.getRight());

        return root;
    }

    private void swapChildren(TreeNode<E> root) {
        TreeNode<E> tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
    }

}
