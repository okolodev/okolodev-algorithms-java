package stack1.adt;

public class ListNode<E> {
    private final E value;
    private ListNode<E> next;

    public ListNode(E value, ListNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public ListNode(E value) {
        this(value, null);
    }

    public E getValue() {
        return value;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

}
