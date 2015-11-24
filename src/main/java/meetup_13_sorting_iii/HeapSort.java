package meetup_13_sorting_iii;

import meetup_11_sorting.Sort;

public class HeapSort<E extends Comparable<E>> implements Sort<E> {

//    @Override
//    public E[] sort(E[] elements) {
//        BinaryHeap<E> heap = new MaxBinaryHeap<>(elements);
//
//        for (int n = elements.length - 1; n >= 0; n--) {
//            elements[n] = heap.extract();
//        }
//
//        return elements;
//    }

    @Override
    public E[] sort(E[] elements) {
        heapify(elements);

        for (int n = elements.length - 1; n > 0; n--) {
            putMaxOnItsPosition(elements, n);
        }

        return elements;
    }

    private void putMaxOnItsPosition(E[] heap, int n) {
        swap(heap, 0, n);
        heapify(heap, 0, n);
    }

    private void heapify(E[] elements) {
        for (int i = elements.length / 2; i >= 0; i--) {
            heapify(elements, i, elements.length);
        }
    }

    private void heapify(E[] elements, int rootIndex, int upTo) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        int largestElementIndex = rootIndex;

        if (leftChildIndex < upTo
                && less(elements[largestElementIndex], elements[leftChildIndex])) {
            largestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < upTo
                && less(elements[largestElementIndex], elements[rightChildIndex])) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != rootIndex) {
            swap(elements, rootIndex, largestElementIndex);
            heapify(elements, largestElementIndex, upTo);
        }
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

    private void swap(E[] heap, int i, int j) {
        E tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

}
