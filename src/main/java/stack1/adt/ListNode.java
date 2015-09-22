package stack1.adt;

public class ListNode<E> {
    private final E value;
    private final ListNode<E> next;

    public ListNode(E value, ListNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public ListNode<E> getNext() {
        return next;
    }

}
