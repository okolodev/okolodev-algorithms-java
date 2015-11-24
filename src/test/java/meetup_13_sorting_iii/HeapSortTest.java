package meetup_13_sorting_iii;

import meetup_11_sorting.AbstractSortTest;

public class HeapSortTest<E extends Comparable<E>> extends AbstractSortTest<E> {

    @Override
    protected HeapSort<E> createSort() {
        return new HeapSort<>();
    }

}
