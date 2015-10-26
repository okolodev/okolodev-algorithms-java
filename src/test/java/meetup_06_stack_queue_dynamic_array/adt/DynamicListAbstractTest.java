package meetup_06_stack_queue_dynamic_array.adt;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class DynamicListAbstractTest {
    private DynamicList<Character> list = createList();

    protected abstract <E> DynamicList<E> createList();

    protected abstract <E> DynamicList<E> createList(E... elements);

    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void itShouldNotBeEmptyWhenElementAdded() {
        list.add('A');

        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void itShouldIncreaseSizeWhenElementsAdded() {
        assertThat("Size mismatch", list.size(), is(0));

        list.add('A');
        assertThat("Size mismatch", list.size(), is(1));

        list.add('B');
        assertThat("Size mismatch", list.size(), is(2));

        list.add('C');
        assertThat("Size mismatch", list.size(), is(3));
    }

    @Test
    public void itShouldDecreaseSizeWhenElementsRemovedByIndex() {
        list.add('A');
        list.add('B');
        list.add('C');

        assertThat("Size mismatch", list.size(), is(3));

        list.remove(1);
        assertThat("Size mismatch", list.size(), is(2));

        list.remove(0);
        assertThat("Size mismatch", list.size(), is(1));

        list.remove(0);
        assertThat("Size mismatch", list.size(), is(0));
    }

    @Test
    public void itShouldGetElementByIndex() {
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');

        assertThat("Element mismatch", list.get(0), is('A'));
        assertThat("Element mismatch", list.get(1), is('B'));
        assertThat("Element mismatch", list.get(2), is('C'));
        assertThat("Element mismatch", list.get(3), is('D'));
    }

    @Test
    public void getElementByIndexShouldBeIdempotent() {
        list.add('A');
        list.add('B');
        list.add('C');

        assertThat(list.get(1), is(list.get(1)));
    }

    @Test
    public void itShouldSetElementByIndex() {
        list.add('A');

        list.set(0, 'B');

        assertThat(list.get(0), is('B'));
    }

    @Test
    public void itShouldRemoveElementByIndex() {
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('F');

        assertThat("Element mismatch", list.remove(4), is('E'));
        assertThat("Element mismatch", list.remove(3), is('D'));
        assertThat("Element mismatch", list.remove(2), is('C'));
        assertThat("Element mismatch", list.remove(0), is('A'));
        assertThat("Element mismatch", list.remove(1), is('F'));
        assertThat("Element mismatch", list.remove(0), is('B'));
    }

    // get exceptions
    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToGetElementByNegativeIndex() {
        list.get(-1);
    }

    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToGetElementByIndexEqualToSize() {
        list.add('A');

        list.get(list.size());
    }

    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToGetElementByIndexGreaterThanSize() {
        list.add('A');

        list.get(list.size() + 1);
    }

    // set exceptions
    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToSetElementByNegativeIndex() {
        list.set(-1, 'A');
    }

    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToSetElementByIndexEqualToSize() {
        list.add('A');

        list.set(list.size(), 'B');
    }

    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToSetElementByIndexGreaterThanSize() {
        list.add('A');

        list.set(list.size() + 1, 'B');
    }

    // remove exceptions
    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToRemoveElementByNegativeIndex() {
        list.remove(-1);
    }

    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToRemoveElementByIndexEqualToSize() {
        list.add('A');

        list.remove(list.size());
    }

    @Test(expected = IndexRangeException.class)
    public void itShouldNotAllowToRemoveElementByIndexGreaterThanSize() {
        list.add('A');

        list.remove(list.size() + 1);
    }

    @Test
    @Parameters(method = "dynamicListsForToString")
    public void itShouldListElementsInToStringMethod(DynamicList<?> dynamicList,
                                                     String toString) {
        assertThat(dynamicList, hasToString(toString));
    }

    @Test
    public void itShouldAllowPassingElementsToConstructor() {
        DynamicList<Integer> list = createList(1, 2, 3, 4, 5, 6);

        assertThat("Element mismatch", list.get(0), is(1));
        assertThat("Element mismatch", list.get(1), is(2));
        assertThat("Element mismatch", list.get(2), is(3));
        assertThat("Element mismatch", list.get(3), is(4));
        assertThat("Element mismatch", list.get(4), is(5));
        assertThat("Element mismatch", list.get(5), is(6));
    }

    private Object[][] dynamicListsForToString() {
        return new Object[][]{
                {createList(), "[]"},
                {createList(1), "[1]"},
                {createList(2, 3), "[2, 3]"},
                {createList(1, 2, 3), "[1, 2, 3]"}
        };
    }

    @Test
    @Parameters(method = "equalDynamicLists")
    public void itShouldBeEqualToAnotherDynamicList(
            DynamicList<Integer> firstList,
            DynamicList<Integer> secondList) {
        assertThat(firstList, is(secondList));
    }

    @Test
    @Parameters(method = "equalDynamicLists")
    public void equalDynamicListsShouldHaveEqualHashCodes(
            DynamicList<Integer> firstList,
            DynamicList<Integer> secondList) {
        assertThat(firstList.hashCode(), is(secondList.hashCode()));
    }

    private Object[][] equalDynamicLists() {
        return new Object[][]{
                {list, list},
                {createList(), createList()},
                {createList(1), createList(1)},
                {createList(2, 3), createList(2, 3)},
                {createList(1, 2, 3), createList(1, 2, 3)},
                {createList(1, 2, 3, 4), createList(1, 2, 3, 4)}
        };
    }

    @Test
    @Parameters(method = "unequalDynamicLists")
    public void itShouldNotBeEqualToAnotherDynamicList(
            DynamicList<Integer> firstList,
            DynamicList<Integer> secondList) {
        assertThat(firstList, is(not(secondList)));
    }

    private Object[][] unequalDynamicLists() {
        return new Object[][]{
                {createList(), null},
                {null, createList()},
                {createList(1), createList()},
                {createList(), createList(1)},
                {createList(3, 2), createList(2, 3)},
                {createList(1, 2, 3), createList(3, 2, 4)},
                {createList(1, 2, 3, 4), createList(1, 2, 3, 4, 5)}
        };
    }

}
