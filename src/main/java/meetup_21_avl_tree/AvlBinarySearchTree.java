package meetup_21_avl_tree;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;
import meetup_18_unbalanced_binary_search_tree.BinarySearchTree;
import meetup_18_unbalanced_binary_search_tree.EmptyBinarySearchTreeException;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

/**
 * <p>
 * AVL Binary Search Tree
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/AVL_tree">AVL Tree</a>
 */
public class AvlBinarySearchTree<E extends Comparable<E>>
        implements BinarySearchTree<E> {
    private int size;
    private AvlTreeNode<E> root;

    private static class AvlTreeNode<E extends Comparable<E>> {
        private final E value;
        private AvlTreeNode<E> left;
        private AvlTreeNode<E> right;

        public AvlTreeNode(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public AvlTreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(AvlTreeNode<E> left) {
            this.left = left;
        }

        public AvlTreeNode<E> getRight() {
            return right;
        }

        public void setRight(AvlTreeNode<E> right) {
            this.right = right;
        }

        public boolean lessThan(E otherValue) {
            return value.compareTo(otherValue) < 0;
        }

        public boolean greaterThan(E otherValue) {
            return value.compareTo(otherValue) > 0;
        }

    }

    @Override
    public boolean insert(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot insert null value.");
        }

        int previousSize = size;
        root = insert(value, root);

        return size != previousSize;
    }

    private AvlTreeNode<E> insert(E value, AvlTreeNode<E> parent) {
        if (parent == null) {
            size++;

            return new AvlTreeNode<>(value);
        }

        if (parent.lessThan(value)) {
            parent.setRight(insert(value, parent.getRight()));
        } else if (parent.greaterThan(value)) {
            parent.setLeft(insert(value, parent.getLeft()));
        }

        return parent;
    }

    @Override
    public boolean contains(E value) {
        AvlTreeNode<E> current = root;

        while (current != null) {
            if (current.lessThan(value)) {
                current = current.getRight();
            } else if (current.greaterThan(value)) {
                current = current.getLeft();
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

    private AvlTreeNode<E> remove(E value, AvlTreeNode<E> parent) {
        if (parent == null) {
            return null;
        }

        if (parent.lessThan(value)) {
            parent.setRight(remove(value, parent.getRight()));
        } else if (parent.greaterThan(value)) {
            parent.setLeft(remove(value, parent.getLeft()));
        } else {
            size--;

            if (parent.getLeft() == null) {
                return parent.getRight();
            } else if (parent.getRight() == null) {
                return parent.getLeft();
            } else {
                AvlTreeNode<E> minSuccessor = findMin(parent.getRight());
                minSuccessor.setRight(removeMin(parent.getRight()));
                minSuccessor.setLeft(parent.getLeft());

                return minSuccessor;
            }
        }

        return parent;
    }

    private AvlTreeNode<E> removeMin(AvlTreeNode<E> parent) {
        if (parent.getLeft() == null) {
            return parent.getRight();
        }

        parent.setLeft(removeMin(parent.getLeft()));
        return parent;
    }

    @Override
    public E min() {
        if (isEmpty()) {
            String message = "There is no min element on an empty binary search tree";
            throw new EmptyBinarySearchTreeException(message);
        }

        return findMin(root).getValue();
    }

    private AvlTreeNode<E> findMin(AvlTreeNode<E> parent) {
        AvlTreeNode<E> min = parent;

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

        AvlTreeNode<E> max = root;

        while (max.getRight() != null) {
            max = max.getRight();
        }

        return max.getValue();
    }

    @Override
    public DynamicList<E> toList() {
        DynamicList<E> list = new ArrayDynamicList<>();
        Stack<AvlTreeNode<E>> stack = new LinkedStack<>();
        AvlTreeNode<E> current = root;

        while (current != null || !stack.isEmpty()) {
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

    public TreeNode<E> toBinaryTree() {
        if (isEmpty()) {
            return null;
        }

        Queue<AvlTreeNode<E>> originalQueue = new LinkedQueue<>();
        originalQueue.enqueue(root);

        TreeNode<E> copyRoot = new TreeNode<E>(root.getValue());
        Queue<TreeNode<E>> copyQueue = new LinkedQueue<>();
        copyQueue.enqueue(copyRoot);

        while (!originalQueue.isEmpty()) {
            AvlTreeNode<E> original = originalQueue.dequeue();
            TreeNode<E> copy = copyQueue.dequeue();

            AvlTreeNode<E> left = original.getLeft();
            if (left != null) {
                originalQueue.enqueue(left);
                TreeNode<E> copyLeft = new TreeNode<>(left.getValue());
                copy.setLeft(copyLeft);
                copyQueue.enqueue(copyLeft);
            }

            AvlTreeNode<E> right = original.getRight();
            if (right != null) {
                originalQueue.enqueue(right);
                TreeNode<E> copyRight = new TreeNode<E>(right.getValue());
                copy.setRight(copyRight);
                copyQueue.enqueue(copyRight);
            }
        }

        return copyRoot;
    }

}
