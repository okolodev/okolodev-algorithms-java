package meetup_06_stack_queue_dynamic_array.adt;

public class LinkedDynamicList<E> implements DynamicList<E> {

    @Override
    public void add(E element) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public E get(int index) {
        return findNode(index).getValue();
    }

    private DoublyListNode<E> findNode(int index) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public void set(int index, E element) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Implement me!");
    }

}
