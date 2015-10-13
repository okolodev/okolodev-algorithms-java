package meetup_07_arrays;

/**
 * @see <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] sumDigits = new int[digits.length];
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            sumDigits[i] = sum;
        }

        if (carry > 0) {
            int[] extendedSumDigits = new int[digits.length + 1];
            extendedSumDigits[0] = carry;
            System.arraycopy(sumDigits, 0, extendedSumDigits, 1, digits.length);

            return extendedSumDigits;
        }

        return sumDigits;
    }

}
