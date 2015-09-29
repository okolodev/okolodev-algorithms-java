package stack_and_queue_5.adt;

/**
 * <p>
 * First In First Out
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Queue_(abstract_data_type)">Queue (abstract data type)</a>
 */
public interface Queue<E> {

    void enqueue(E element);

    E dequeue();

    boolean isEmpty();

    int size();

}
