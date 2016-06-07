package meetup_33_anagarams_and_reverse_int;

/**
 * 7. Reverse Integer
 *
 * @see <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>
 */
public class ReverseInteger {

    public int reverse(int original) {
        boolean positive = original > 0;
        int absolute = Math.abs(original);
        int reversed = 0;

        while (absolute > 0) {
            int lastDigit = absolute % 10;
            int newReversed = reversed * 10 + lastDigit;

            // overflow check
            if ((newReversed - lastDigit) / 10 != reversed) {
                return 0;
            }

            reversed = newReversed;
            absolute = absolute / 10;
        }

        if (!positive) {
            return -reversed;
        }

        return reversed;
    }

    public int reverse2(int original) {
        boolean positive = original > 0;
        int absolute = Math.abs(original);
        long reversed = 0;

        while (absolute > 0) {
            int lastDigit = absolute % 10;
            reversed = reversed * 10 + lastDigit;
            absolute = absolute / 10;
        }

        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }

        if (!positive) {
            return (int) -reversed;
        }

        return (int) reversed;
    }

}
