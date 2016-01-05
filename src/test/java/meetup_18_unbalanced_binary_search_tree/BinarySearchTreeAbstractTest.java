package meetup_18_unbalanced_binary_search_tree;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class BinarySearchTreeAbstractTest {
    private DynamicList<Character> emptyList = new ArrayDynamicList<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private BinarySearchTree<Character> binarySearchTree = createBinarySearchTree();

    protected abstract BinarySearchTree<Character> createBinarySearchTree();

    // Emptiness
    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(binarySearchTree.isEmpty(), is(true));
    }

    @Test
    public void itShouldBeOfZeroSizeWhenCreated() {
        assertThat(binarySearchTree.size(), is(0));
    }

    // Operations on an empty binary search tree
    @Test
    public void itShouldReturnEmptyToListWhenTreeIsEmpty() {
        assertThat(binarySearchTree.toList(), is(emptyList));
    }

    @Test
    public void itShouldNotContainAnyValueWhenTreeIsEmpty() {
        assertThat(binarySearchTree.contains('A'), is(false));
    }

    @Test
    public void removalShouldNotDecreaseSizeWhenTreeIsEmpty() {
        binarySearchTree.remove('D');

        assertThat(binarySearchTree.size(), is(0));
    }

    @Test
    public void itShouldNotAllowMinInvocationWhenTreeIsEmpty() {
        thrown.expect(EmptyBinarySearchTreeException.class);
        thrown.expectMessage("There is no min element on an empty binary search tree");

        binarySearchTree.min();
    }

    @Test
    public void itShouldNotAllowMaxInvocationWhenTreeIsEmpty() {
        thrown.expect(EmptyBinarySearchTreeException.class);
        thrown.expectMessage("There is no max element on an empty binary search tree");

        binarySearchTree.max();
    }

    // Null values
    @Test
    public void itShouldNotAllowInsertingNullValue() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Cannot insert null value");

        binarySearchTree.insert(null);
    }

    @Test
    public void itShouldNotAllowNullValueRemoval() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Cannot remove null value");

        binarySearchTree.remove(null);
    }

    @Test
    public void itShouldInsertNewValue() {
        assertThat(binarySearchTree.insert('C'), is(true));
    }

    @Test
    public void itShouldIncreaseSizeWhenNewValueInserted() {
        binarySearchTree.insert('D');

        assertThat(binarySearchTree.size(), is(1));
    }

    @Test
    public void itShouldNotBeEmptyWhenNewValueInserted() {
        binarySearchTree.insert('E');

        assertThat(binarySearchTree.isEmpty(), is(false));
    }

    @Test
    @Parameters(method = "values")
    public void itShouldContainInsertedValues(Character[] values,
                                              Character value) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        assertThat(binarySearchTree.contains(value), is(true));
    }

    private Object[][] values() {
        return new Object[][]{
                {new Character[]{'A'}, 'A'},

                {new Character[]{'A', 'B'}, 'A'},
                {new Character[]{'A', 'B'}, 'B'},

                {new Character[]{'B', 'C', 'A'}, 'A'},
                {new Character[]{'B', 'C', 'A'}, 'B'},
                {new Character[]{'B', 'C', 'A'}, 'C'},

                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'A'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'B'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'C'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'D'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'E'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'F'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'G'},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'}, 'H'}
        };
    }

    @Test
    @Parameters(method = "valuesAndDuplicate")
    public void itShouldNotInsertDuplicateValue(Character[] values,
                                                Character duplicate) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        assertThat(binarySearchTree.insert(duplicate), is(false));
    }

    @Test
    @Parameters(method = "valuesAndDuplicate")
    public void itShouldNotIncreaseSizeWhenDuplicateInserted(Character[] values,
                                                             Character duplicate) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        binarySearchTree.insert(duplicate);

        assertThat(binarySearchTree.size(), is(values.length));
    }

    private Object[][] valuesAndDuplicate() {
        return values();
    }

    @Test
    @Parameters(method = "valuesAndToBeRemoved")
    public void itShouldNotContainRemovedElement(Character[] values,
                                                 Character toBeRemoved) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        binarySearchTree.remove(toBeRemoved);

        assertThat(binarySearchTree.contains(toBeRemoved), is(false));
    }

    @Test
    @Parameters(method = "valuesAndToBeRemoved")
    public void itShouldDecreaseSizeWhenElementRemoved(Character[] values,
                                                       Character toBeRemoved) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        binarySearchTree.remove(toBeRemoved);

        assertThat(binarySearchTree.size(), is(values.length - 1));
    }

    private Object[][] valuesAndToBeRemoved() {
        return values();
    }

    @Test
    public void itShouldRemoveValues() {
        Character[] values = {'E', 'B', 'D', 'A', 'G', 'F', 'H'};
        Arrays.stream(values).forEach(binarySearchTree::insert);

        binarySearchTree.remove('G');
        assertThat("contains mismatch", binarySearchTree.contains('G'), is(false));

        binarySearchTree.remove('E');
        assertThat("contains mismatch", binarySearchTree.contains('E'), is(false));

        binarySearchTree.remove('F');
        assertThat("contains mismatch", binarySearchTree.contains('F'), is(false));

        binarySearchTree.remove('D');
        assertThat("contains mismatch", binarySearchTree.contains('D'), is(false));

        binarySearchTree.remove('B');
        assertThat("contains mismatch", binarySearchTree.contains('B'), is(false));

        binarySearchTree.remove('H');
        assertThat("contains mismatch", binarySearchTree.contains('H'), is(false));

        binarySearchTree.remove('A');
        assertThat("contains mismatch", binarySearchTree.contains('A'), is(false));
    }

    @Test
    @Parameters(method = "insertRemoveValues")
    public void itShouldBeEmptyWhenAllInsertedValuesAreDeleted(Character[] values) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        Arrays.stream(values).forEach(binarySearchTree::remove);

        assertThat(binarySearchTree.isEmpty(), is(true));
    }

    private Object[][] insertRemoveValues() {
        return new Object[][]{
                {new Character[]{}},
                {new Character[]{'A'}},
                {new Character[]{'A', 'B'}},
                {new Character[]{'B', 'A'}},
                {new Character[]{'D', 'B', 'C'}},
                {new Character[]{'H', 'F', 'A', 'E'}},
                {new Character[]{'E', 'B', 'D', 'A', 'G', 'F', 'H'}}
        };
    }

    @Test
    public void itShouldSupportMinValue() {
        binarySearchTree.insert('C');
        assertThat("min value mismatch", binarySearchTree.min(), is('C'));

        binarySearchTree.insert('D');
        assertThat("min value mismatch", binarySearchTree.min(), is('C'));

        binarySearchTree.insert('F');
        assertThat("min value mismatch", binarySearchTree.min(), is('C'));

        binarySearchTree.insert('B');
        assertThat("min value mismatch", binarySearchTree.min(), is('B'));

        binarySearchTree.insert('H');
        assertThat("min value mismatch", binarySearchTree.min(), is('B'));

        binarySearchTree.insert('A');
        assertThat("min value mismatch", binarySearchTree.min(), is('A'));
    }

    @Test
    public void itShouldSupportMaxValue() {
        binarySearchTree.insert('C');
        assertThat("max value mismatch", binarySearchTree.max(), is('C'));

        binarySearchTree.insert('A');
        assertThat("max value mismatch", binarySearchTree.max(), is('C'));

        binarySearchTree.insert('D');
        assertThat("max value mismatch", binarySearchTree.max(), is('D'));

        binarySearchTree.insert('B');
        assertThat("max value mismatch", binarySearchTree.max(), is('D'));

        binarySearchTree.insert('F');
        assertThat("max value mismatch", binarySearchTree.max(), is('F'));

        binarySearchTree.insert('H');
        assertThat("max value mismatch", binarySearchTree.max(), is('H'));
    }

    @Test
    @Parameters(method = "valuesAndSortedValues")
    public void toListShouldReturnValuesInSortedOrder(
            Character[] values, DynamicList<Character> sortedValues) {
        Arrays.stream(values).forEach(binarySearchTree::insert);

        assertThat(binarySearchTree.toList(), is(sortedValues));
    }

    private Object[][] valuesAndSortedValues() {
        return new Object[][]{
                {new Character[]{}, toList()},
                {new Character[]{'C'}, toList('C')},
                {new Character[]{'B', 'C', 'A'}, toList('A', 'B', 'C')},
                {new Character[]{'D', 'B', 'E', 'C', 'A'},
                        toList('A', 'B', 'C', 'D', 'E')},
                {new Character[]{'D', 'A', 'B', 'C', 'G', 'E', 'F', 'H'},
                        toList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H')}
        };
    }

    private <E> DynamicList<E> toList(E... values) {
        return new ArrayDynamicList<>(values);
    }

}
