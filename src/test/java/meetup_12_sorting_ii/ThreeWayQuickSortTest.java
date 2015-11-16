package meetup_12_sorting_ii;

import meetup_11_sorting.AbstractSortTest;

public class ThreeWayQuickSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected ThreeWayQuickSort<E> createSort() {
        return new ThreeWayQuickSort<>();
    }

}
