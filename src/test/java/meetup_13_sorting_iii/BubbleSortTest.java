package meetup_13_sorting_iii;

import meetup_11_sorting.AbstractSortTest;

public class BubbleSortTest<E extends Comparable<E>> extends AbstractSortTest<E> {

    @Override
    protected BubbleSort<E> createSort() {
        return new BubbleSort<>();
    }

}
