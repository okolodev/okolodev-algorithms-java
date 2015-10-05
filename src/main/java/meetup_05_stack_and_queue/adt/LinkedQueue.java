package meetup_05_stack_and_queue.adt;

import stack1.adt.ListNode;

public class LinkedQueue<E> implements Queue<E> {
    private ListNode<E> front;
    private ListNode<E> back;
    private int size;

    @Override
    public void enqueue(E element) {
        ListNode<E> node = new ListNode<E>(element);

        if (isEmpty()) {
            front = node;
            back = node;
        } else {
            back.setNext(node);
            back = node;
        }

        size++;
    }

    @Override
    public E dequeue() {
        E element = front.getValue();
        front = front.getNext();
        size--;

        if (isEmpty()) {
            back = null;
        }

        return element;
    }

    @Override
    public E peek() {
        return front.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
