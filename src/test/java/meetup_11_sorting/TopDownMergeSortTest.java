package meetup_11_sorting;

public class TopDownMergeSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected TopDownMergeSort<E> createSort() {
        return new TopDownMergeSort<>();
    }

}
