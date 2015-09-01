package singly_linked_list1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LinkedListCycleIITest {

    @Test
    @Parameters(method = "cyclic")
    public void itShouldDetectCycle(ListNode head, ListNode cycle) {
        assertThat(detectCycle(head), is(cycle));
    }

    private Object[][] cyclic() {
        ListNode lengthOfOne = new ListNode(1);
        lengthOfOne.setNext(lengthOfOne);

        ListNode lengthOfTwoEnd = new ListNode(2);
        ListNode lengthOfTwo = new ListNode(1, lengthOfTwoEnd);
        lengthOfTwoEnd.setNext(lengthOfTwo);

        ListNode lengthOfFiveEnd = new ListNode(5);
        ListNode lengthOfFive = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, lengthOfFiveEnd))));
        lengthOfFiveEnd.setNext(lengthOfFive.getNext().getNext());

        return new Object[][]{
                {lengthOfOne, lengthOfOne},
                {lengthOfTwo, lengthOfTwoEnd.getNext()},
                {lengthOfFive, lengthOfFiveEnd.getNext()}
        };
    }

    @Test
    @Parameters(method = "acyclic")
    public void itShouldNotDetectCycle(ListNode head) {
        assertThat(detectCycle(head), is(nullValue()));
    }

    private Object[][] acyclic() {
        return new Object[][]{
                {null},
                {new ListNode(1)},
                {new ListNode(1, new ListNode(2))},
                {new ListNode(1, new ListNode(2, new ListNode(3)))}
        };
    }

    private ListNode detectCycle(ListNode head) {
        throw new UnsupportedOperationException("Implement me!");
    }

}
