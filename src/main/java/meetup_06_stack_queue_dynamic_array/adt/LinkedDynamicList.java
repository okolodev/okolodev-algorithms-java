package meetup_06_stack_queue_dynamic_array.adt;

public class LinkedDynamicList<E> implements DynamicList<E> {
    private DoublyListNode<E> front;
    private DoublyListNode<E> back;
    private int size;

    @Override
    public void add(E element) {
        DoublyListNode<E> node = new DoublyListNode<>(element);

        if (isEmpty()) {
            front = node;
            back = node;
        } else {
            node.setPrevious(back);
            back.setNext(node);
            back = node;
        }

        size++;
    }

    @Override
    public E get(int index) {
        return findNode(index).getValue();
    }

    private DoublyListNode<E> findNode(int index) {
        checkIndexRange(index);
        DoublyListNode<E> current;

        if (index <= size / 2) {
            current = front;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = back;

            for (int i = size - 1; i > index; i--) {
                current = current.getPrevious();
            }
        }

        return current;
    }

    private void checkIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexRangeException("There is no such index: " + index);
        }
    }

    @Override
    public void set(int index, E element) {
        findNode(index).setValue(element);
    }

    @Override
    public E remove(int index) {
        DoublyListNode<E> node = findNode(index);
        DoublyListNode<E> previous = node.getPrevious();
        DoublyListNode<E> next = node.getNext();

        if (previous != null && next != null) {
            previous.setNext(next);
            next.setPrevious(previous);
        } else if (previous != null) {
            previous.setNext(null);
            back = previous;
        } else if (next != null) {
            next.setPrevious(null);
            front = next;
        } else {
            front = null;
            back = null;
        }

        size--;

        return node.getValue();
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
