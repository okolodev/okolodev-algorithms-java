package meetup_29_fully_persistent_array;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;

public class PathCopyingFullyPersistentArray<E> implements FullyPersistentArray<E> {
    private final int size;
    private DynamicList<Node> roots = new ArrayDynamicList<>();

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> node) {
            this(node.getValue());
            left = node.getLeft();
            right = node.getRight();
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    public PathCopyingFullyPersistentArray(E... elements) {
        size = elements.length;

        Queue<E> elementQueue = new LinkedQueue<>();
        for (E element : elements) {
            elementQueue.enqueue(element);
        }

        Queue<Node<E>> nodeQueue = new LinkedQueue<>();
        Node<E> root = new Node<>(elementQueue.dequeue());
        nodeQueue.enqueue(root);

        while (!elementQueue.isEmpty()) {
            Node<E> parent = nodeQueue.dequeue();

            Node<E> left = new Node<>(elementQueue.dequeue());
            parent.setLeft(left);
            nodeQueue.enqueue(left);

            if (!elementQueue.isEmpty()) {
                Node<E> right = new Node<>(elementQueue.dequeue());
                parent.setRight(right);
                nodeQueue.enqueue(right);
            }
        }

        roots.add(root);
    }

    @Override
    public int update(int version, int index, E newValue) {
        checkIndexRange(index);
        int oneBasedIndex = index + 1;
        int depth = depth(oneBasedIndex);
        Node<E> nextRoot = new Node<>(roots.get(version));
        Node<E> current = nextRoot;

        while (depth > 0) {
            depth--;
            int direction = direction(oneBasedIndex, depth);

            if (direction == 0) {
                Node<E> left = new Node<>(current.getLeft());
                current.setLeft(left);
                current = left;
            } else {
                Node<E> right = new Node<>(current.getRight());
                current.setRight(right);
                current = right;
            }
        }

        current.setValue(newValue);
        roots.add(nextRoot);

        return currentVersion();
    }

    private int direction(int oneBasedIndex, int depth) {
        return (oneBasedIndex >> depth) % 2;
    }

    @Override
    public E get(int version, int index) {
        checkIndexRange(index);
        int oneBasedIndex = index + 1;
        int depth = depth(oneBasedIndex);
        Node<E> current = roots.get(version);

        while (depth > 0) {
            depth--;
            int direction = direction(oneBasedIndex, depth);

            if (direction == 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return current.getValue();
    }

    private void checkIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of range.");
        }
    }

    private int depth(int oneBasedIndex) {
        return 31 - Integer.numberOfLeadingZeros(oneBasedIndex);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int currentVersion() {
        return roots.size() - 1;
    }

}
