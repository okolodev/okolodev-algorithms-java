package meetup_07_arrays;

/**
 * Similar to the Majority Element.
 *
 * @see <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 */
public class ContainsMajorityElement {

    public boolean containsMajorityElement(int[] elements) {
        if (elements.length == 0) {
            return false;
        }

        int candidate = findCandidate(elements);

        return countFrequency(candidate, elements) > elements.length / 2;

    }

    private int findCandidate(int[] elements) {
        int candidate = elements[0];
        int votes = 1;

        for (int i = 1; i < elements.length; i++) {
            if (candidate != elements[i]) {
                votes--;

                if (votes == 0) {
                    candidate = elements[i];
                    votes = 1;
                }
            } else {
                votes++;
            }
        }

        return candidate;
    }

    private int countFrequency(int candidate, int[] elements) {
        int frequency = 0;

        for (int element : elements) {
            if (candidate == element) {
                frequency++;
            }
        }

        return frequency;
    }

}
