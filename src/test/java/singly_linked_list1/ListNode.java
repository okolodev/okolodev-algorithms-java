package singly_linked_list1;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class ListNode {
    private final int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this(val);
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    // Avoid calling this method for lists with a cycle.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val
                && Objects.equals(next, listNode.next);
    }

    // Avoid calling this method for lists with a cycle.
    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return toString(new IdentityHashMap<>());
    }

    private String toString(Map<ListNode, Object> traversed) {
        if (traversed.containsKey(this)) {
            return "@" + val;
        }

        traversed.put(this, null);

        if (next == null) {
            return String.valueOf(val);
        }

        return val + " -> " + next.toString(traversed);
    }

}
