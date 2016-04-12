package meetup_29_fully_persistent_array;

public class BruteForceFullyPersistentArrayTest extends AbstractFullyPersistentArrayTest {

    @Override
    protected BruteForceFullyPersistentArray<String> createPersistentArray(String[] sourceArray) {
        return new BruteForceFullyPersistentArray<>(sourceArray);
    }

}
