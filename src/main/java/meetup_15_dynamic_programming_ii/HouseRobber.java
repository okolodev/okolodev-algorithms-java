package meetup_15_dynamic_programming_ii;

/**
 * <p>
 * House Robber.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/house-robber/">198 House Robber</a>
 */
public class HouseRobber {

    public int rob(int[] houses) {
        int previousAmount = 0;
        int previousPreviousAmount = 0;
        int max = 0;

        for (int amount : houses) {
            max = Math.max(previousPreviousAmount + amount, previousAmount);

            previousPreviousAmount = previousAmount;
            previousAmount = max;
        }

        return max;
    }

    public int robDynamic(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }

        if (houses.length == 1) {
            return houses[0];
        }

        int[] stolenAmounts = new int[houses.length];

        stolenAmounts[0] = houses[0];
        stolenAmounts[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            stolenAmounts[i] = Math.max(stolenAmounts[i - 2] + houses[i],
                    stolenAmounts[i - 1]);
        }

        return stolenAmounts[houses.length - 1];
    }

}
