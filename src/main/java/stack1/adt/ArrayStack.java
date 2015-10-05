package stack1.adt;

public class ArrayStack<E> implements Stack<E> {
    private final E[] holder;
    private int next;

    public ArrayStack(int capacity) {
        holder = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        holder[next++] = element;
    }

    @Override
    public E pop() {
        E element = holder[--next];
        holder[next] = null;
        return element;
    }

    @Override
    public E peek() {
        return holder[next - 1];
    }

    @Override
    public boolean isEmpty() {
        return next == 0;
    }

    @Override
    public int size() {
        return next;
    }

}
