package math2.bit.xor;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SingleNumberIITest {

    @Test
    @Parameters(method = "data")
    public void itShouldFindSingleNumber(int[] numbers, int single) {
        assertThat(findSingleNumber(numbers), is(single));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{5}, 5},
                {new int[]{1, 1, 2, 1}, 2},
                {new int[]{1, 1, 1, 2}, 2},
                {new int[]{2, 1, 1, 2, 3, 1, 2}, 3},
                {new int[]{2, 1, 2, 1, 4, 3, 2, 3, 1, 3}, 4}
        };
    }

    private int findSingleNumber(int[] numbers) {
        int ones = 0;
        int twos = 0;

        for (int n : numbers) {
            int prevOnes = ones;
            ones = (ones ^ n) & ~twos;
            twos = (twos & ~n) | (prevOnes & n);

            traceBits("n", n);
            traceBits("prev ones", prevOnes);
            traceBits("ones", ones);
            traceBits("twos", twos);
        }

        traceBits("result", ones);

        return ones;
    }

    private void traceBits(String name, int v) {
        String paddedBits = String.format("%4s", Integer.toBinaryString(v))
                .replace(' ', '0');
        System.out.printf("%-10s%-5s%-5s%n", name, v, paddedBits);

    }

}
