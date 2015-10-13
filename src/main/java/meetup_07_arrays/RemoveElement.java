package meetup_07_arrays;

/**
 * @see <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 */
public class RemoveElement {

    public int removeElement(int[] numbers, int element) {
        int length = numbers.length;
        int elementNumber = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == element) {
                length--;
                elementNumber++;
            } else {
                numbers[i - elementNumber] = numbers[i];

                if (elementNumber > 0) {
                    numbers[i] = element;
                }
            }
        }

        return length;
    }

}
