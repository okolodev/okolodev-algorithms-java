package stack1.adt;

public class LinkedStack<E> implements Stack<E> {
    private ListNode<E> head;

    @Override
    public void push(E element) {
        head = new ListNode<>(element, head);
    }

    @Override
    public E pop() {
        E element = head.getValue();
        head = head.getNext();
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

}
