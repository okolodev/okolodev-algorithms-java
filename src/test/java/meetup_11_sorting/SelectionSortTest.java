package meetup_11_sorting;

public class SelectionSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected SelectionSort<E> createSort() {
        return new SelectionSort<>();
    }

}
