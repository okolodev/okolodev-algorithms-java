package meetup_29_fully_persistent_array;

public class PathCopyingFullyPersistentArray<E> implements FullyPersistentArray<E> {

    public PathCopyingFullyPersistentArray(String[] elements) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int update(int version, int index, E newValue) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public E get(int version, int index) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int currentVersion() {
        throw new UnsupportedOperationException("Implement me!");
    }

}
