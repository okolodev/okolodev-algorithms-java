package meetup_13_sorting_iii;

public class MaxBinaryHeap<E extends Comparable<E>> implements BinaryHeap<E> {
    private final E[] heap;
    private int size;

    public MaxBinaryHeap(int capacity) {
        heap = (E[]) new Comparable[capacity];
    }

    public MaxBinaryHeap(E... elements) {
        heap = elements.clone();
        size = elements.length;

        heapify();
    }

    private void heapify() {
        for (int i = size / 2; i >= 0; i--) {
            heapify(i);
        }

    }

    private void heapify(int rootIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        int largestElementIndex = rootIndex;

        if (leftChildIndex < size
                && less(heap[largestElementIndex], heap[leftChildIndex])) {
            largestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < size
                && less(heap[largestElementIndex], heap[rightChildIndex])) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != rootIndex) {
            swap(rootIndex, largestElementIndex);
            heapify(largestElementIndex);
        }
    }

    private boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }

    private void swap(int i, int j) {
        E tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    @Override
    public void insert(E element) {
        heap[size++] = element;
        heapify((size - 1) / 2);
    }

    @Override
    public E peek() {
        return heap[0];
    }

    @Override
    public E extract() {
        swap(0, --size);
        E element = heap[size];
        heap[size] = null;

        heapify(0);

        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
