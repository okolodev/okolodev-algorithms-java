package stack1.adt;

/**
 * <p>
 * Last In First Out
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Stack_(abstract_data_type)">Stack_(abstract_data_type)</a>
 */
public interface Stack<E> {

    void push(E element);

    E pop();

    E peek();

    boolean isEmpty();

}
