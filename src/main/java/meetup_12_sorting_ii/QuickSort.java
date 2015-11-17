package meetup_12_sorting_ii;

import meetup_11_sorting.Sort;

public class QuickSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        // possible optimisation
        // shuffle elements
        quickSort(elements, 0, elements.length - 1);

        return elements;
    }

    private void quickSort(E[] elements, int low, int high) {
        if (high <= low) {
            return;
        }

        int pivot = partition(elements, low, high);
        quickSort(elements, low, pivot - 1);
        quickSort(elements, pivot + 1, high);
    }

    private int partition(E[] elements, int low, int high) {
        int left = low;
        int right = high + 1;

        // possible optimisation
        // find a median between low, middle and high
        // with subsequent swapping median with low
        // reducing to the same algorithm
        E pivot = elements[low];

        while (true) {
            while (less(elements[++left], pivot)) {
                if (left == high) {
                    break;
                }
            }

            while (less(pivot, elements[--right])) {
                if (right == low) {
                    break;
                }
            }

            if (right <= left) {
                break;
            }

            swap(elements, left, right);
        }

        swap(elements, low, right);

        return right;
    }

    private void swap(E[] elements, int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

}
