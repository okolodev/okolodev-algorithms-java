package meetup_20_rotate_array_and_three_sum;

import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_06_stack_queue_dynamic_array.adt.LinkedDynamicList;
import stack1.adt.ListNode;

/**
 * <p>
 * 189. Rotate Array
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
 */
public class RotateArray {

    public void rotate(int[] numbers, int positions) {
        int length = numbers.length;

        if (length <= 1) {
            return;
        }

        positions = positions % length;

        if (positions == 0) {
            return;
        }

        reverse(numbers, 0, length - 1);
        reverse(numbers, 0, positions - 1);
        reverse(numbers, positions, length - 1);
    }

    private void reverse(int[] numbers, int low, int high) {
        for (int i = low; i <= low + (high - low) / 2; i++) {
            swap(numbers, i, high - (i - low));
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public void rotate2(int[] numbers, int positions) {
        int length = numbers.length;

        if (length <= 1) {
            return;
        }

        positions = positions % length;

        if (positions == 0) {
            return;
        }

        int[] doubleCopy = new int[2 * length];
        System.arraycopy(numbers, 0, doubleCopy, 0, length);
        System.arraycopy(numbers, 0, doubleCopy, length, length);

        System.arraycopy(doubleCopy, length - positions, numbers, 0, length);
    }

    public void rotate3(int[] numbers, int positions) {
        int length = numbers.length;

        if (length <= 1) {
            return;
        }

        positions = positions % length;

        if (positions == 0) {
            return;
        }

        int[] copy = numbers.clone();

        System.arraycopy(copy, 0, numbers, positions, length - positions);
        System.arraycopy(copy, length - positions, numbers, 0, positions);
    }

    public void rotate4(int[] numbers, int positions) {
        int length = numbers.length;

        if (length <= 1) {
            return;
        }

        positions = positions % length;

        if (positions == 0) {
            return;
        }

        int[] copy = numbers.clone();

        for (int i = 0; i < positions; i++) {
            numbers[i] = copy[length - positions + i];
        }

        for (int i = positions; i < length; i++) {
            numbers[i] = copy[i - positions];
        }
    }

    public void rotate5(int[] numbers, int positions) {
        int length = numbers.length;

        if (length <= 1) {
            return;
        }

        positions = positions % length;

        if (positions == 0) {
            return;
        }

        DynamicList<Integer> list = new LinkedDynamicList<>();

        for (int number : numbers) {
            list.add(number);
        }

        for (int i = 0; i < length - positions; i++) {
            int start = list.remove(0);
            list.add(start);
        }

        for (int i = 0; i < length; i++) {
            numbers[i] = list.get(i);
        }
    }

    public void rotate6(int[] numbers, int positions) {
        int length = numbers.length;

        if (length <= 1) {
            return;
        }

        positions = positions % length;

        if (positions == 0) {
            return;
        }

        ListNode<Integer> start = new ListNode<>(numbers[0]);
        ListNode<Integer> end = start;

        for (int i = 1; i < length; i++) {
            ListNode<Integer> next = new ListNode<>(numbers[i]);
            end.setNext(next);
            end = next;
        }

        ListNode<Integer> newStart = start;
        for (int i = 0; i < length - positions; i++) {
            newStart = newStart.getNext();
        }

        end.setNext(start);

        for (int i = 0; i < length; i++) {
            numbers[i] = newStart.getValue();
            newStart = newStart.getNext();
        }
    }

}
