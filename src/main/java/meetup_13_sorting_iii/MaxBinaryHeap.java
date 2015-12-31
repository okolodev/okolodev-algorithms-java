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
            heapifyDown(i);
        }

    }

    private void heapifyDown(int parentIndex) {
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;
        int largestElementIndex = parentIndex;

        if (leftChildIndex < size
                && less(heap[largestElementIndex], heap[leftChildIndex])) {
            largestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < size
                && less(heap[largestElementIndex], heap[rightChildIndex])) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != parentIndex) {
            swap(parentIndex, largestElementIndex);
            heapifyDown(largestElementIndex);
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
        heapifyUp(size - 1);
    }

    private void heapifyUp(int childIndex) {
        if (childIndex == 0) {
            return;
        }

        int parentIndex = (childIndex - 1) / 2;
        if (less(heap[parentIndex], heap[childIndex])) {
            swap(parentIndex, childIndex);
            heapifyUp(parentIndex);
        }
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

        heapifyDown(0);

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
