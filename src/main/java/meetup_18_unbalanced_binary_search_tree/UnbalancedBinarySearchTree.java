package meetup_18_unbalanced_binary_search_tree;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

/**
 * <p>
 * Unbalanced Binary Search Tree.
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_tree">Wikipedia - Binary search tree</a>,
 * <a href="http://visualgo.net/bst.html">Visualgo - Binary search tree</a>
 */
public class UnbalancedBinarySearchTree<E extends Comparable<E>>
        implements BinarySearchTree<E> {
    private int size;
    private TreeNode<E> root;

    private static class TreeNode<E extends Comparable<E>> {
        private final E value;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
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

        public boolean greaterThan(E otherValue) {
            return value.compareTo(otherValue) > 0;
        }

        public boolean lessThan(E otherValue) {
            return value.compareTo(otherValue) < 0;
        }

    }

    @Override
    public boolean insert(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot insert null value");
        }

        if (isEmpty()) {
            root = new TreeNode<>(value);
        } else {
            TreeNode<E> current = root;

            while (true) {
                if (current.greaterThan(value)) {
                    if (current.getLeft() == null) {
                        current.setLeft(new TreeNode<>(value));
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else if (current.lessThan(value)) {
                    if (current.getRight() == null) {
                        current.setRight(new TreeNode<>(value));
                        break;
                    } else {
                        current = current.getRight();
                    }
                } else {
                    return false;
                }
            }
        }

        size++;
        return true;
    }

    @Override
    public boolean contains(E value) {
        TreeNode<E> current = root;

        while (current != null) {
            if (current.greaterThan(value)) {
                current = current.getLeft();
            } else if (current.lessThan(value)) {
                current = current.getRight();
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public void remove(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot remove null value");
        }

        root = remove(value, root);
    }

    private TreeNode<E> remove(E value, TreeNode<E> subTree) {
        if (subTree == null) {
            return null;
        }

        if (subTree.greaterThan(value)) {
            subTree.setLeft(remove(value, subTree.getLeft()));
        } else if (subTree.lessThan(value)) {
            subTree.setRight(remove(value, subTree.getRight()));
        } else {
            size--;

            if (subTree.getLeft() == null) {
                return subTree.getRight();
            } else if (subTree.getRight() == null) {
                return subTree.getLeft();
            } else {
                TreeNode<E> minSuccessor = findMin(subTree.getRight());
                minSuccessor.setRight(removeMin(subTree.getRight()));
                minSuccessor.setLeft(subTree.getLeft());

                return minSuccessor;
            }
        }

        return subTree;
    }

    private TreeNode<E> removeMin(TreeNode<E> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }

        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

    @Override
    public E min() {
        if (isEmpty()) {
            String message = "There is no min element on an empty binary search tree";
            throw new EmptyBinarySearchTreeException(message);
        }

        return findMin(root).getValue();
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        TreeNode<E> min = node;

        while (min.getLeft() != null) {
            min = min.getLeft();
        }

        return min;
    }

    @Override
    public E max() {
        if (isEmpty()) {
            String message = "There is no max element on an empty binary search tree";
            throw new EmptyBinarySearchTreeException(message);
        }

        TreeNode<E> max = root;

        while (max.getRight() != null) {
            max = max.getRight();
        }

        return max.getValue();
    }

    @Override
    public DynamicList<E> toList() {
        DynamicList<E> list = new ArrayDynamicList<>();
        Stack<TreeNode<E>> stack = new LinkedStack<>();

        TreeNode<E> current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                list.add(current.getValue());
                current = current.getRight();
            }
        }

        return list;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
