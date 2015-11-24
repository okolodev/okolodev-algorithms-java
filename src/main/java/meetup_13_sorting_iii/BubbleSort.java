package meetup_13_sorting_iii;

import meetup_11_sorting.Sort;

public class BubbleSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        int n = elements.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (less(elements[i], elements[i - 1])) {
                    swap(elements, i, i - 1);
                    swapped = true;
                }
            }

            n = n - 1;
        } while (swapped);

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
