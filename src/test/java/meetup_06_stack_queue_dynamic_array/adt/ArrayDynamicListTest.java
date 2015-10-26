package meetup_06_stack_queue_dynamic_array.adt;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayDynamicListTest extends DynamicListAbstractTest {
    private ArrayDynamicList<Character> list = createList();

    @Override
    protected <E> ArrayDynamicList<E> createList() {
        return new ArrayDynamicList<>();
    }

    @Override
    protected <E> DynamicList<E> createList(E... elements) {
        return new ArrayDynamicList<>(elements);
    }

    @Test
    public void itShouldTwoTimesIncreaseCapacityWhenElementsAdded() {
        assertThat("Capacity mismatch", list.capacity(), is(0));

        list.add('1');
        assertThat("Capacity mismatch", list.capacity(), is(1));

        list.add('2');
        assertThat("Capacity mismatch", list.capacity(), is(2));

        list.add('3');
        assertThat("Capacity mismatch", list.capacity(), is(4));

        list.add('4');
        assertThat("Capacity mismatch", list.capacity(), is(4));
    }

    @Test
    public void itShouldFourTimesDecreaseCapacityWhenElementsRemoved() {
        ArrayDynamicList<Character> list = createList();
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        list.add('0');

        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');

        assertThat("Capacity mismatch", list.capacity(), is(32));

        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(4);
        list.remove(5);
        list.remove(6);
        list.remove(7);
        list.remove(8);
        assertThat("Capacity mismatch", list.capacity(), is(32));

        list.remove(1);
        assertThat("Capacity mismatch", list.capacity(), is(8));

        list.remove(6);
        list.remove(5);
        list.remove(4);
        list.remove(3);
        list.remove(2);
        assertThat("Capacity mismatch", list.capacity(), is(8));

        list.remove(1);
        assertThat("Capacity mismatch", list.capacity(), is(2));

        list.remove(0);
        assertThat("Capacity mismatch", list.capacity(), is(2));

        list.remove(0);
        assertThat("Capacity mismatch", list.capacity(), is(0));
    }

}
