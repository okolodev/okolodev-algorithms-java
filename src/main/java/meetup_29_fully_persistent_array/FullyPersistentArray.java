package meetup_29_fully_persistent_array;

public interface FullyPersistentArray<E> {

    int update(int version, int index, E newValue);

    E get(int version, int index);

    int size();

    int currentVersion();

}
