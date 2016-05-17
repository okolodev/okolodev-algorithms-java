package meetup_31_bloom_filter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BloomFilterTest {
    private int size = 50;
    private int hashFunctionNumber = 4;
    private BloomFilter filter = new BloomFilter(size, hashFunctionNumber);

    @Test
    public void itShouldHaveSetSize() {
        assertThat(filter.getSize(), is(size));
    }

    @Test
    public void itShouldHaveSetHashFunctionNumber() {
        assertThat(filter.getHashFunctionNumber(), is(hashFunctionNumber));
    }

    @Test
    @Parameters(method = "keys")
    public void emptyFilterShouldNotContainKeys(String key) {
        assertThat(filter.contains(key), is(false));
    }

    @Test
    @Parameters(method = "keys")
    public void itShouldContainPutKeys(String key) {
        filter.put(key);

        assertThat(filter.contains(key), is(true));
    }

    private Object[][] keys() {
        return new Object[][]{
                {"one"},
                {"two"},
                {"lovely cat"},
                {"mad dog"},
                {"Bloom filter"},
                {"Is awesome!"}
        };
    }

}
