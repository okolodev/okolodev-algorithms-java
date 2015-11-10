package meetup_11_sorting;

public class BottomUpMergeSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        throw new UnsupportedOperationException("Implement me!");
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

}
