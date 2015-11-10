package meetup_11_sorting;

public class TopDownMergeSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        E[] aux = (E[]) new Comparable[elements.length];

        sort(elements, 0, elements.length - 1, aux);

        return elements;
    }

    private void sort(E[] elements, int low, int high, E[] aux) {
        if (high <= low) {
            return;
        }

        int middle = low + (high - low) / 2;
        sort(elements, low, middle, aux);
        sort(elements, middle + 1, high, aux);

        merge(elements, low, middle, high, aux);
    }

    private void merge(E[] elements, int low, int middle, int high, E[] aux) {
        for (int i = low; i <= high; i++) {
            aux[i] = elements[i];
        }

        int left = low;
        int right = middle + 1;

        for (int k = low; k <= high; k++) {
            if (left > middle) {
                elements[k] = aux[right++];
            } else if (right > high) {
                elements[k] = aux[left++];
            } else if (less(aux[right], aux[left])) {
                elements[k] = aux[right++];
            } else {
                elements[k] = aux[left++];
            }
        }
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

}
