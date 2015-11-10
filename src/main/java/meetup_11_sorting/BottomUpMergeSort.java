package meetup_11_sorting;

public class BottomUpMergeSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        int n = elements.length;
        E[] aux = (E[]) new Comparable[n];

        for (int size = 1; size < n; size = size + size) {
            for (int low = 0; low < n - size; low = low + size + size) {
                int middle = low + size - 1;
                int high = Math.min(low + size + size, n) - 1;
                merge(elements, low, middle, high, aux);
            }
        }

        return elements;
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
