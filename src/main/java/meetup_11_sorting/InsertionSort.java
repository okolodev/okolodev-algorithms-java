package meetup_11_sorting;

public class InsertionSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        throw new UnsupportedOperationException("Implement me!");
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

    private void swap(E[] elements, int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

}
