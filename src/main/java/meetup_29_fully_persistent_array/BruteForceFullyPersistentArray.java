package meetup_29_fully_persistent_array;

import java.util.ArrayList;
import java.util.List;

public class BruteForceFullyPersistentArray<E> implements FullyPersistentArray<E> {
    private final List<E[]> versions = new ArrayList<>();

    public BruteForceFullyPersistentArray(E... elements) {
        versions.add(elements.clone());
    }

    @Override
    public int update(int version, int index, E newValue) {
        E[] clone = versions.get(version).clone();
        clone[index] = newValue;
        versions.add(clone);

        return currentVersion();
    }

    @Override
    public E get(int version, int index) {
        return versions.get(version)[index];
    }

    @Override
    public int size() {
        return versions.get(0).length;
    }

    @Override
    public int currentVersion() {
        return versions.size() - 1;
    }

}
