package meetup_29_fully_persistent_array;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class AbstractFullyPersistentArrayTest {
    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    protected abstract FullyPersistentArray<String> createPersistentArray(String[] sourceArray);

    @Test
    @Parameters(method = "sourceArrays")
    public void itShouldHaveSizeOfSourceArray(String[] sourceArray) {
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);

        assertThat(persistentArray.size(), is(sourceArray.length));
    }

    @Test
    @Parameters(method = "sourceArrays")
    public void itShouldHaveCurrentVersionOfZeroWhenCreated(String[] sourceArray) {
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);
        int initialVersion = 0;

        assertThat(persistentArray.currentVersion(), is(initialVersion));
    }

    @Test
    @Parameters(method = "sourceArrays")
    public void itShouldProvideInitialVersionElement(String[] sourceArray) {
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);
        int initialVersion = 0;

        IntStream.range(0, sourceArray.length)
                .forEach(i -> assertThat(persistentArray.get(initialVersion, i), is(sourceArray[i])));
    }

    @Test
    @Parameters(method = "sourceArrays")
    public void itShouldThrowIndexOutOfBoundExceptionWhenGetsIndexWhichIsGreaterThanLastElementIndex(String[] sourceArray) {
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);
        int initialVersion = 0;

        thrownException.expect(IndexOutOfBoundsException.class);

        persistentArray.get(initialVersion, sourceArray.length);
    }

    @Test
    @Parameters(method = "sourceArrays")
    public void itShouldThrowIndexOutOfBoundExceptionWhenUpdatesIndexWhichIsGreaterThanLastElementIndex(String[] sourceArray) {
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);
        int initialVersion = 0;

        thrownException.expect(IndexOutOfBoundsException.class);

        persistentArray.update(initialVersion, sourceArray.length, "new value");
    }

    private String[][] sourceArrays() {
        return new String[][]{
                {"a"},
                {"b", "c"},
                {"e", "f", "g"},
                {"a", "b", "c", "d"},
                {"a", "b", "c", "d", "e"},
                {"a", "b", "c", "d", "e", "f"},
                {"a", "b", "c", "d", "e", "f", "g"},
                {"a", "b", "c", "d", "e", "f", "g", "h"},
                {"a", "b", "c", "d", "e", "f", "g", "h", "i"},
                {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"},
                {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"}
        };
    }

    @Test
    @Parameters(method = "versionIncrementSource")
    public void itShouldIncreaseVersionWhenElementUpdated(String[] sourceArray,
                                                          int index,
                                                          String newValue) {
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);
        int previousVersion = persistentArray.currentVersion();

        int newVersion = persistentArray.update(previousVersion, index, newValue);

        assertThat(newVersion, is(previousVersion + 1));
    }

    private Object[][] versionIncrementSource() {
        return new Object[][]{
                {new String[]{"a"}, 0, "x"},
                {new String[]{"b", "c"}, 0, "x"},
                {new String[]{"b", "c"}, 1, "x"},
                {new String[]{"a", "b", "c"}, 0, "x"},
                {new String[]{"e", "f", "g"}, 2, "x"},
                {new String[]{"a", "b", "c", "d"}, 3, "x"},
                {new String[]{"a", "b", "c", "d", "e"}, 4, "x"},
                {new String[]{"a", "b", "c", "d", "e", "f"}, 5, "x"},
                {new String[]{"a", "b", "c", "d", "e", "f", "g"}, 6, "x"},
                {new String[]{"a", "b", "c", "d", "e", "f", "g", "h"}, 7, "x"},
                {new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"}, 8, "x"},
                {new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, 9, "x"},
                {new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"}, 10, "x"},
        };
    }

    @Test
    public void itShouldUpdateDifferentVersionsOfElements() {
        String[] sourceArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        FullyPersistentArray<String> persistentArray =
                createPersistentArray(sourceArray);

        int initialVersion = persistentArray.currentVersion();

        int firstVersion = persistentArray.update(initialVersion, 3, "a");
        assertThat(firstVersion, is(1));

        assertThat(persistentArray.get(initialVersion, 0), is("0"));
        assertThat(persistentArray.get(initialVersion, 1), is("1"));
        assertThat(persistentArray.get(initialVersion, 2), is("2"));
        assertThat(persistentArray.get(initialVersion, 3), is("3"));
        assertThat(persistentArray.get(initialVersion, 4), is("4"));
        assertThat(persistentArray.get(initialVersion, 5), is("5"));
        assertThat(persistentArray.get(initialVersion, 6), is("6"));
        assertThat(persistentArray.get(initialVersion, 7), is("7"));
        assertThat(persistentArray.get(initialVersion, 8), is("8"));

        assertThat(persistentArray.get(firstVersion, 0), is("0"));
        assertThat(persistentArray.get(firstVersion, 1), is("1"));
        assertThat(persistentArray.get(firstVersion, 2), is("2"));
        assertThat(persistentArray.get(firstVersion, 3), is("a"));
        assertThat(persistentArray.get(firstVersion, 4), is("4"));
        assertThat(persistentArray.get(firstVersion, 4), is("4"));
        assertThat(persistentArray.get(firstVersion, 5), is("5"));
        assertThat(persistentArray.get(firstVersion, 6), is("6"));
        assertThat(persistentArray.get(firstVersion, 7), is("7"));
        assertThat(persistentArray.get(firstVersion, 8), is("8"));

        int secondVersion = persistentArray.update(firstVersion, 1, "b");
        assertThat(secondVersion, is(2));

        assertThat(persistentArray.get(firstVersion, 0), is("0"));
        assertThat(persistentArray.get(firstVersion, 1), is("1"));
        assertThat(persistentArray.get(firstVersion, 2), is("2"));
        assertThat(persistentArray.get(firstVersion, 3), is("a"));
        assertThat(persistentArray.get(firstVersion, 4), is("4"));
        assertThat(persistentArray.get(firstVersion, 5), is("5"));
        assertThat(persistentArray.get(firstVersion, 6), is("6"));
        assertThat(persistentArray.get(firstVersion, 7), is("7"));
        assertThat(persistentArray.get(firstVersion, 8), is("8"));

        assertThat(persistentArray.get(secondVersion, 0), is("0"));
        assertThat(persistentArray.get(secondVersion, 1), is("b"));
        assertThat(persistentArray.get(secondVersion, 2), is("2"));
        assertThat(persistentArray.get(secondVersion, 3), is("a"));
        assertThat(persistentArray.get(secondVersion, 4), is("4"));
        assertThat(persistentArray.get(secondVersion, 5), is("5"));
        assertThat(persistentArray.get(secondVersion, 6), is("6"));
        assertThat(persistentArray.get(secondVersion, 7), is("7"));
        assertThat(persistentArray.get(secondVersion, 8), is("8"));

        int thirdVersion = persistentArray.update(initialVersion, 2, "c");
        assertThat(thirdVersion, is(3));

        assertThat(persistentArray.get(initialVersion, 0), is("0"));
        assertThat(persistentArray.get(initialVersion, 1), is("1"));
        assertThat(persistentArray.get(initialVersion, 2), is("2"));
        assertThat(persistentArray.get(initialVersion, 3), is("3"));
        assertThat(persistentArray.get(initialVersion, 4), is("4"));
        assertThat(persistentArray.get(initialVersion, 5), is("5"));
        assertThat(persistentArray.get(initialVersion, 6), is("6"));
        assertThat(persistentArray.get(initialVersion, 7), is("7"));
        assertThat(persistentArray.get(initialVersion, 8), is("8"));

        assertThat(persistentArray.get(thirdVersion, 0), is("0"));
        assertThat(persistentArray.get(thirdVersion, 1), is("1"));
        assertThat(persistentArray.get(thirdVersion, 2), is("c"));
        assertThat(persistentArray.get(thirdVersion, 3), is("3"));
        assertThat(persistentArray.get(thirdVersion, 4), is("4"));
        assertThat(persistentArray.get(thirdVersion, 5), is("5"));
        assertThat(persistentArray.get(thirdVersion, 6), is("6"));
        assertThat(persistentArray.get(thirdVersion, 7), is("7"));
        assertThat(persistentArray.get(thirdVersion, 8), is("8"));

        int fourthVersion = persistentArray.update(thirdVersion, 4, "d");
        assertThat(fourthVersion, is(4));

        assertThat(persistentArray.get(thirdVersion, 0), is("0"));
        assertThat(persistentArray.get(thirdVersion, 1), is("1"));
        assertThat(persistentArray.get(thirdVersion, 2), is("c"));
        assertThat(persistentArray.get(thirdVersion, 3), is("3"));
        assertThat(persistentArray.get(thirdVersion, 4), is("4"));
        assertThat(persistentArray.get(thirdVersion, 5), is("5"));
        assertThat(persistentArray.get(thirdVersion, 6), is("6"));
        assertThat(persistentArray.get(thirdVersion, 7), is("7"));
        assertThat(persistentArray.get(thirdVersion, 8), is("8"));

        assertThat(persistentArray.get(fourthVersion, 0), is("0"));
        assertThat(persistentArray.get(fourthVersion, 1), is("1"));
        assertThat(persistentArray.get(fourthVersion, 2), is("c"));
        assertThat(persistentArray.get(fourthVersion, 3), is("3"));
        assertThat(persistentArray.get(fourthVersion, 4), is("d"));
        assertThat(persistentArray.get(fourthVersion, 5), is("5"));
        assertThat(persistentArray.get(fourthVersion, 6), is("6"));
        assertThat(persistentArray.get(fourthVersion, 7), is("7"));
        assertThat(persistentArray.get(fourthVersion, 8), is("8"));

        int fifthVersion = persistentArray.update(fourthVersion, 7, "e");
        assertThat(fifthVersion, is(5));

        assertThat(persistentArray.get(fourthVersion, 0), is("0"));
        assertThat(persistentArray.get(fourthVersion, 1), is("1"));
        assertThat(persistentArray.get(fourthVersion, 2), is("c"));
        assertThat(persistentArray.get(fourthVersion, 3), is("3"));
        assertThat(persistentArray.get(fourthVersion, 4), is("d"));
        assertThat(persistentArray.get(fourthVersion, 5), is("5"));
        assertThat(persistentArray.get(fourthVersion, 6), is("6"));
        assertThat(persistentArray.get(fourthVersion, 7), is("7"));
        assertThat(persistentArray.get(fourthVersion, 8), is("8"));

        assertThat(persistentArray.get(fifthVersion, 0), is("0"));
        assertThat(persistentArray.get(fifthVersion, 1), is("1"));
        assertThat(persistentArray.get(fifthVersion, 2), is("c"));
        assertThat(persistentArray.get(fifthVersion, 3), is("3"));
        assertThat(persistentArray.get(fifthVersion, 4), is("d"));
        assertThat(persistentArray.get(fifthVersion, 5), is("5"));
        assertThat(persistentArray.get(fifthVersion, 6), is("6"));
        assertThat(persistentArray.get(fifthVersion, 7), is("e"));
        assertThat(persistentArray.get(fifthVersion, 8), is("8"));
    }

}
