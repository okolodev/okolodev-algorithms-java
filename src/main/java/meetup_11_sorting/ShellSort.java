package meetup_11_sorting;

public class ShellSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public E[] sort(E[] elements) {
        int n = elements.length;

        int step = 1;
        while (step < n / 3) {
            step = step * 3 + 1;
        }

        while (step > 0) {
            for (int i = step; i < n; i++) {
                for (int j = i; j >= step && less(elements[j], elements[j - step]); j--) {
                    swap(elements, j, j - step);
                }
            }

            step = step / 3;
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
