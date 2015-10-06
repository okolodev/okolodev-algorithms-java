package meetup_06_stack_queue_dynamic_array.adt;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class DynamicListAbstractTest {
    private DynamicList<Character> list = createList();

    protected abstract <E> DynamicList<E> createList();

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

}
