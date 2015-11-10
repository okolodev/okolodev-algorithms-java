package meetup_11_sorting;

public class BottomUpMergeSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected BottomUpMergeSort<E> createSort() {
        return new BottomUpMergeSort<>();
    }

}
