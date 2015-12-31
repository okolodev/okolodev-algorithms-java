package meetup_13_sorting_iii;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxBinaryHeapTest {
    private BinaryHeap<Character> heap = new MaxBinaryHeap<>(4);

    @Test
    public void itShouldBeEmptyWhenCreatedWithoutInitialData() {
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void itShouldHaveSizeOfZeroWhenCreatedWithoutInitialData() {
        assertThat(heap.size(), is(0));
    }

    @Test
    public void itShouldNotBeEmptyWhenElementInserted() {
        heap.insert('A');

        assertThat(heap.isEmpty(), is(false));
    }

    @Test
    public void itShouldIncreaseSizeWhenElementInserted() {
        heap.insert('A');
        assertThat("size mismatch after the first insert", heap.size(), is(1));

        heap.insert('B');
        assertThat("size mismatch after the second insert", heap.size(), is(2));
    }

    @Test
    public void itShouldPeekMaxElement() {
        heap.insert('A');
        assertThat(heap.peek(), is('A'));

        heap.insert('B');
        assertThat(heap.peek(), is('B'));

        heap.insert('A');
        assertThat(heap.peek(), is('B'));
    }

    @Test
    public void itShouldExtractMaxElementWhenCreatedWithInitialData() {
        heap = new MaxBinaryHeap<>('A', 'F', 'B', 'D', 'I', 'J', 'H', 'E', 'K', 'C', 'G', 'D');

        assertThat(heap.extract(), is('K'));

        assertThat(heap.extract(), is('J'));

        assertThat(heap.extract(), is('I'));

        assertThat(heap.extract(), is('H'));

        assertThat(heap.extract(), is('G'));

        assertThat(heap.extract(), is('F'));

        assertThat(heap.extract(), is('E'));

        assertThat(heap.extract(), is('D'));

        assertThat(heap.extract(), is('D'));

        assertThat(heap.extract(), is('C'));

        assertThat(heap.extract(), is('B'));

        assertThat(heap.extract(), is('A'));
    }

    @Test
    public void itShouldSupportMaxElementValue() {
        heap.insert('A');
        assertThat("max element mismatch", heap.peek(), is('A'));

        heap.insert('C');
        assertThat("max element mismatch", heap.peek(), is('C'));

        heap.insert('D');
        assertThat("max element mismatch", heap.peek(), is('D'));

        heap.insert('B');
        assertThat("max element mismatch", heap.peek(), is('D'));
    }

}
