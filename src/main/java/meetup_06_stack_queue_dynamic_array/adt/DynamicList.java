package meetup_06_stack_queue_dynamic_array.adt;

public interface DynamicList<E> {

    void add(E element);

    E get(int index);

    void set(int index, E element);

    E remove(int index);

    int size();

    boolean isEmpty();

}
