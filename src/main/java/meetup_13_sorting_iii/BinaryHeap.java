package meetup_13_sorting_iii;

public interface BinaryHeap<E extends Comparable<E>> {

    void insert(E element);

    E peek();

    E extract();

    int size();

    boolean isEmpty();

}
