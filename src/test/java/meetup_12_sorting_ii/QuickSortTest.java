package meetup_12_sorting_ii;

import meetup_11_sorting.AbstractSortTest;

public class QuickSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected QuickSort<E> createSort() {
        return new QuickSort<>();
    }

}
