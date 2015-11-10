package meetup_11_sorting;

public class InsertionSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        for (int i = 1; i < elements.length; i++) {
            for (int j = i; j > 0 && less(elements[j], elements[j - 1]); j--) {
                swap(elements, j, j - 1);
            }
        }

        return elements;
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
