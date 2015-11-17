package meetup_12_sorting_ii;

public class InversionCounter<E extends Comparable<E>> {

    public int countInversions(E[] elements) {
        int inversions = 0;

        int n = elements.length;
        E[] aux = (E[]) new Comparable[n];

        for (int size = 1; size < n; size = size + size) {
            for (int low = 0; low < n - size; low = low + size + size) {
                int middle = low + size - 1;
                int high = Math.min(low + size + size, n) - 1;

                inversions += merge(elements, low, middle, high, aux);
            }
        }

        return inversions;
    }

    private int merge(E[] elements, int low, int middle, int high, E[] aux) {
        for (int i = low; i <= high; i++) {
            aux[i] = elements[i];
        }

        int inversions = 0;

        int left = low;
        int right = middle + 1;

        for (int k = low; k <= high; k++) {
            if (left > middle) {
                elements[k] = aux[right++];
            } else if (right > high) {
                elements[k] = aux[left++];
            } else if (less(aux[right], aux[left])) {
                inversions += right - k;
                elements[k] = aux[right++];
            } else {
                elements[k] = aux[left++];
            }
        }

        return inversions;
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

}
