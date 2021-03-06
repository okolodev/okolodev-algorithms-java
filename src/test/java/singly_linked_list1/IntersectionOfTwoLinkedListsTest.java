package singly_linked_list1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class IntersectionOfTwoLinkedListsTest {

    @Test
    @Parameters(method = "intersecting")
    public void itShouldFindIntersection(ListNode headA,
                                         ListNode headB,
                                         ListNode intersection) {
        assertThat(getIntersectionNode(headA, headB), is(intersection));
    }

    private Object[][] intersecting() {
        ListNode lengthOfOne = new ListNode(1);

        ListNode lengthOfTwoA = new ListNode(1, new ListNode(2));
        ListNode lengthOfTwoIntersection = lengthOfTwoA.getNext();
        ListNode lengthOfTwoB = new ListNode(3, new ListNode(4,
                lengthOfTwoIntersection));

        ListNode lengthOfFiveA = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode lengthOfFiveIntersection = lengthOfFiveA.getNext().getNext();
        ListNode lengthOfFiveB = new ListNode(6, lengthOfFiveIntersection);

        return new Object[][]{
                {lengthOfOne, lengthOfOne, lengthOfOne},
                {lengthOfTwoA, lengthOfTwoB, lengthOfTwoIntersection},
                {lengthOfFiveA, lengthOfFiveB, lengthOfFiveIntersection}
        };
    }

    @Test
    @Parameters(method = "notIntersecting")
    public void itShouldFindNotIntersection(ListNode headA, ListNode headB) {
        assertThat(getIntersectionNode(headA, headB), is(nullValue()));
    }

    private Object[][] notIntersecting() {
        return new Object[][]{
                {null, null},
                {new ListNode(1), null},
                {null, new ListNode(2)},
                {new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(2))},
                {new ListNode(1), new ListNode(1, new ListNode(2, new ListNode(3)))},
        };
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode tailA = headA;
        ListNode tailB = headB;

        if (lengthA > lengthB) {
            tailA = getNthNode(tailA, lengthA - lengthB);
        } else if (lengthB > lengthA) {
            tailB = getNthNode(tailB, lengthB - lengthA);
        }

        while (tailA != null) {
            if (tailA == tailB) {
                return tailA;
            }

            tailA = tailA.getNext();
            tailB = tailB.getNext();
        }

        return null;
    }

    private ListNode getNthNode(ListNode head, int n) {
        ListNode tail = head;

        for (int i = 0; i < n; i++) {
            tail = tail.getNext();
        }

        return tail;
    }

    private int getLength(ListNode head) {
        int length = 0;

        ListNode tail = head;
        while (tail != null) {
            length++;
            tail = tail.getNext();
        }

        return length;
    }

}
