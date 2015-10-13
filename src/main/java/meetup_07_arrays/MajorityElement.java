package meetup_07_arrays;

/**
 * @see <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 */
public class MajorityElement {

    public int majorityElement(int[] elements) {
        int candidate = elements[0];
        int votes = 1;

        for (int i = 1; i < elements.length; i++) {
            if (candidate == elements[i]) {
                votes++;
            } else {
                votes--;

                if (votes == 0) {
                    candidate = elements[i];
                    votes = 1;
                }
            }
        }

        return candidate;
    }

}
