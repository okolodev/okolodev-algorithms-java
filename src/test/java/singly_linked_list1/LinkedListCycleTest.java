package singly_linked_list1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LinkedListCycleTest {

    @Test
    @Parameters(method = "acyclic,cyclic")
    public void itShouldCheckIfListHasACycle(ListNode head, boolean cyclic) {
        assertThat(hasCycle(head), is(cyclic));
    }

    private Object[][] acyclic() {
        return new Object[][]{
                {null, false},
                {new ListNode(1), false},
                {new ListNode(1, new ListNode(2)), false},
                {new ListNode(1, new ListNode(2, new ListNode(3))), false}
        };
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
                {lengthOfOne, true},
                {lengthOfTwo, true},
                {lengthOfFive, true}
        };
    }

    private boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
