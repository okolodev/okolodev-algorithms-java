package meetup_12_sorting_ii;

import meetup_11_sorting.Sort;

public class ThreeWayQuickSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        threeWayQuickSort(elements, 0, elements.length - 1);

        return elements;
    }

    private void threeWayQuickSort(E[] elements, int low, int high) {
        if (high <= low) {
            return;
        }

        int lessThan = low;
        int i = low + 1;
        int greaterThan = high;

        E pivot = elements[low];

        while (i <= greaterThan) {
            int cmp = elements[i].compareTo(pivot);

            if (cmp < 0) {
                swap(elements, i++, lessThan++);
            } else if (cmp > 0) {
                swap(elements, greaterThan--, i);
            } else {
                i++;
            }
        }

        threeWayQuickSort(elements, low, lessThan - 1);
        threeWayQuickSort(elements, greaterThan + 1, high);
    }

    private void swap(E[] elements, int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

}
