package meetup_11_sorting;

public class InsertionSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected InsertionSort<E> createSort() {
        return new InsertionSort<>();
    }

}
