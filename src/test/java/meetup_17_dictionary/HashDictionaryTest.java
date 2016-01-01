package meetup_17_dictionary;

import meetup_17_dictionary.misc.Employee;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class HashDictionaryTest extends DictionaryAbstractTest {
    private int anySalary = 50_000;

    private HashDictionary<Employee, Integer> employeeToSalary = createDictionary();

    @Override
    protected HashDictionary<Employee, Integer> createDictionary() {
        return new HashDictionary<>((double) 2 / 3);
    }

    @Test
    public void itShouldIncreaseCapacityOnDemand() {
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(0));

        employeeToSalary.insert(johnDoe, anySalary);
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(2));

        employeeToSalary.insert(thomasSmith, anySalary);
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(5));

        employeeToSalary.insert(aliceCooper, anySalary);
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(5));
    }

    @Test
    public void itShouldDecreaseCapacityOnDemand() {
        employeeToSalary.insert(aliceCooper, anySalary);
        employeeToSalary.insert(johnDoe, anySalary);
        employeeToSalary.insert(thomasSmith, anySalary);

        assertThat("capacity mismatch", employeeToSalary.capacity(), is(5));

        employeeToSalary.remove(johnDoe);
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(5));

        employeeToSalary.remove(thomasSmith);
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(3));

        employeeToSalary.remove(aliceCooper);
        assertThat("capacity mismatch", employeeToSalary.capacity(), is(2));
    }

}
