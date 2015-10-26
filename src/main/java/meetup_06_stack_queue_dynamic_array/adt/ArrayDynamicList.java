package meetup_06_stack_queue_dynamic_array.adt;

import java.util.Arrays;
import java.util.Objects;

public class ArrayDynamicList<E> implements DynamicList<E> {
    private E[] holder = (E[]) new Object[]{};
    private int size;

    public ArrayDynamicList() {
    }

    public ArrayDynamicList(E... elements) {
        holder = Arrays.copyOf(elements, elements.length);
        size = holder.length;
    }

    @Override
    public void add(E element) {
        increaseCapasityOnDemand();
        holder[size++] = element;
    }

    private void increaseCapasityOnDemand() {
        if (size == holder.length) {
            int newLength = Math.max(1, size * 2);
            E[] newHolder = (E[]) new Object[newLength];
            System.arraycopy(holder, 0, newHolder, 0, size);

            holder = newHolder;
        }
    }

    @Override
    public E get(int index) {
        checkIndexRange(index);

        return holder[index];
    }

    @Override
    public void set(int index, E element) {
        checkIndexRange(index);

        holder[index] = element;
    }

    @Override
    public E remove(int index) {
        checkIndexRange(index);

        E element = holder[index];
        holder[index] = null;

        int numberToMove = size - 1 - index;
        System.arraycopy(holder, index + 1, holder, index, numberToMove);

        size--;
        shrinkOnDemand();

        return element;
    }

    private void shrinkOnDemand() {
        if (size <= capacity() / 4) {
            holder = Arrays.copyOfRange(holder, 0, capacity() / 4);
        }
    }

    private void checkIndexRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexRangeException("There is no such index: " + index);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return holder.length;
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder("[");

        String separator = "";
        for (int i = 0; i < size; i++) {
            stringRepresentation.append(separator)
                    .append(holder[i]);
            separator = ", ";
        }

        stringRepresentation.append("]");

        return stringRepresentation.toString();
    }

    @Override
    public int hashCode() {
        // not efficient, but quickly-written implementation.
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DynamicList)) {
            return false;
        }

        DynamicList<E> that = (DynamicList<E>) o;

        if (size != that.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(get(i), that.get(i))) {
                return false;
            }
        }

        return true;
    }

}
