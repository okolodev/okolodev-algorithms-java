package meetup_06_stack_queue_dynamic_array.adt;

public class DoublyListNode<E> {
    private E value;
    private DoublyListNode<E> previous;
    private DoublyListNode<E> next;

    public DoublyListNode(E value) {
        this(null, value, null);
    }

    public DoublyListNode(DoublyListNode<E> previous,
                          E value,
                          DoublyListNode<E> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public DoublyListNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyListNode<E> previous) {
        this.previous = previous;
    }

    public DoublyListNode<E> getNext() {
        return next;
    }

    public void setNext(DoublyListNode<E> next) {
        this.next = next;
    }

}
