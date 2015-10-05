package meetup_05_stack_and_queue.adt;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Circular_buffer">Circular buffer</a>
 */
public class ArrayQueue<E> implements Queue<E> {
    private E[] holder;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(int capacity) {
        holder = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        holder[back++] = element;

        back = normalizeIndex(back);
        size++;
    }

    private int normalizeIndex(int index) {
        return index % holder.length;
    }

    @Override
    public E dequeue() {
        E element = holder[front];
        holder[front++] = null;

        front = normalizeIndex(front);
        size--;

        return element;
    }

    @Override
    public E peek() {
        return holder[front];
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
