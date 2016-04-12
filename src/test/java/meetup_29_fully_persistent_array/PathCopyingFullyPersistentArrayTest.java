package meetup_29_fully_persistent_array;

public class PathCopyingFullyPersistentArrayTest extends AbstractFullyPersistentArrayTest {

    @Override
    protected PathCopyingFullyPersistentArray<String> createPersistentArray(String[] sourceArray) {
        return new PathCopyingFullyPersistentArray<>(sourceArray);
    }

}
