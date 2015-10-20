package meetup_08_tree_traversal.adt;

import java.util.Objects;

public class TreeNode<E> {
    private final E value;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E value) {
        this(null, value, null);
    }

    public TreeNode(TreeNode<E> left, E value) {
        this(left, value, null);
    }

    public TreeNode(E value, TreeNode<E> right) {
        this(null, value, right);
    }

    public TreeNode(TreeNode<E> left, E value, TreeNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TreeNode)) {
            return false;
        }

        TreeNode<E> treeNode = (TreeNode<E>) o;

        return Objects.equals(value, treeNode.value)
                && Objects.equals(left, treeNode.left)
                && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (left != null) {
            result.append(left)
                    .append(", ");
        }

        result.append(value);

        if (right != null) {
            result.append(", ")
                    .append(right);
        }

        return result.toString();
    }

}
