package meetup_14_multiway_merge_and_dynamic_programming;

/**
 * Merge k Sorted Lists.
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23 Merge k Sorted Lists</a>.
 */
public class MultiWayMerge<E extends Comparable<E>> {

    public E[] merge(E[][] arrays) {
        int elementsNumber = 0;
        MinBinaryHeap<ArrayWrapper<E>> heap = new MinBinaryHeap<>(arrays.length);

        for (E[] array : arrays) {
            elementsNumber += array.length;

            if (array.length > 0) {
                heap.insert(new ArrayWrapper<>(array));
            }
        }

        E[] merged = (E[]) new Comparable[elementsNumber];


        for (int i = 0; i < elementsNumber; i++) {
            ArrayWrapper<E> arrayWrapper = heap.remove();
            merged[i] = arrayWrapper.readNext();

            if (!arrayWrapper.isEmpty()) {
                heap.insert(arrayWrapper);
            }
        }

        return merged;
    }

}

class ArrayWrapper<E extends Comparable<E>> implements Comparable<ArrayWrapper<E>> {
    private final E[] array;
    private int elementsRead;

    public ArrayWrapper(E[] array) {
        this.array = array;
    }

    boolean isEmpty() {
        return elementsRead == array.length;
    }

    E readNext() {
        return array[elementsRead++];
    }

    @Override
    public int compareTo(ArrayWrapper<E> other) {
        return array[elementsRead].compareTo(other.array[other.elementsRead]);
    }

    @Override
    public String toString() {
        return String.valueOf(array[elementsRead]);
    }

}

class MinBinaryHeap<E extends Comparable<E>> {
    private final E[] heap;
    private int size;

    public MinBinaryHeap(int capacity) {
        heap = (E[]) new Comparable[capacity];
    }

    void insert(E element) {
        heap[size++] = element;
        heapifyUp();
    }

    private void heapifyUp() {
        heapifyUp(size - 1);
    }

    private void heapifyUp(int childIndex) {
        if (childIndex == 0) {
            return;
        }

        int parentIndex = (childIndex - 1) / 2;
        if (greater(heap[parentIndex], heap[childIndex])) {
            swap(parentIndex, childIndex);
            heapifyUp(parentIndex);
        }
    }

    private boolean greater(E a, E b) {
        return a.compareTo(b) > 0;
    }

    private void swap(int i, int j) {
        E tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    E remove() {
        swap(0, size - 1);
        E minElement = heap[--size];
        heapifyDown(0);

        return minElement;
    }

    private void heapifyDown(int parentIndex) {
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;
        int lestElementIndex = parentIndex;

        if (leftChildIndex < size
                && greater(heap[lestElementIndex], heap[leftChildIndex])) {
            lestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < size
                && greater(heap[lestElementIndex], heap[rightChildIndex])) {
            lestElementIndex = rightChildIndex;
        }

        if (lestElementIndex != parentIndex) {
            swap(parentIndex, lestElementIndex);
            heapifyDown(lestElementIndex);
        }
    }

}

