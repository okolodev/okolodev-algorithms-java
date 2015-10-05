package stack1.adt;

public class LinkedStack<E> implements Stack<E> {
    private ListNode<E> head;
    private int size;

    @Override
    public void push(E element) {
        head = new ListNode<>(element, head);
        size++;
    }

    @Override
    public E pop() {
        E element = head.getValue();
        head = head.getNext();
        size--;
        return element;
    }

    @Override
    public E peek() {
        return head.getValue();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

}
