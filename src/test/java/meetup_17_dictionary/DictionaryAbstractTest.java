package meetup_17_dictionary;

import junitparams.JUnitParamsRunner;
import meetup_17_dictionary.misc.Employee;
import meetup_17_dictionary.misc.IdenticalHashCodeEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class DictionaryAbstractTest {
    public final Employee johnDoe = new Employee("John Doe", 1);
    public final Employee thomasSmith = new Employee("Thomas Smith", 2);
    public final Employee aliceCooper = new Employee("Alice Cooper", 2);

    public final Employee emilyIdenticalHashCode =
            new IdenticalHashCodeEmployee("Emily Fischer", 0);
    public final Employee sabineIdenticalHashCode =
            new IdenticalHashCodeEmployee("Sabine Koch", 1);

    private Dictionary<Employee, Integer> employeeToSalary = createDictionary();

    protected abstract Dictionary<Employee, Integer> createDictionary();

    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(employeeToSalary.isEmpty(), is(true));
    }

    @Test
    public void itShouldHaveZeroSizeWhenCreated() {
        assertThat(employeeToSalary.size(), is(0));
    }

    @Test
    public void itShouldHaveBeNotEmptyWhenElementInserted() {
        employeeToSalary.insert(johnDoe, 55_000);

        assertThat(employeeToSalary.isEmpty(), is(false));
    }

    @Test
    public void itShouldNotHaveZeroSizeWhenElementInserted() {
        employeeToSalary.insert(thomasSmith, 48_000);

        assertThat(employeeToSalary.size(), is(1));
    }

    @Test
    public void itShouldGetInsertedValueByKey() {
        employeeToSalary.insert(thomasSmith, 48_000);

        assertThat(employeeToSalary.get(thomasSmith), is(48_000));
    }

    @Test
    public void itShouldIncreaseSizeWhenElementsInserted() {
        employeeToSalary.insert(johnDoe, 55_000);
        assertThat("size mismatch", employeeToSalary.size(), is(1));

        employeeToSalary.insert(thomasSmith, 48_000);
        assertThat("size mismatch", employeeToSalary.size(), is(2));

        employeeToSalary.insert(aliceCooper, 10_000_000);
        assertThat("size mismatch", employeeToSalary.size(), is(3));
    }

    @Test
    public void itShouldGetNullForNonexistentKey() {
        assertThat(employeeToSalary.get(new Employee("Nonexistent", -1)),
                is(nullValue()));
    }

    @Test
    public void itShouldContainInsertedValuesByKey() {
        employeeToSalary.insert(johnDoe, 55_000);
        employeeToSalary.insert(thomasSmith, 48_000);
        employeeToSalary.insert(aliceCooper, 10_000_000);

        assertThat("Thomas Smith's contains mismatch",
                employeeToSalary.contains(thomasSmith), is(true));
        assertThat("John Doe's contains mismatch",
                employeeToSalary.contains(johnDoe), is(true));
        assertThat("Alice Cooper's contains mismatch",
                employeeToSalary.contains(aliceCooper), is(true));
    }

    @Test
    public void itShouldGetInsertedValuesByKey() {
        employeeToSalary.insert(johnDoe, 55_000);
        employeeToSalary.insert(thomasSmith, 48_000);
        employeeToSalary.insert(aliceCooper, 10_000_000);

        assertThat("Thomas Smith's value mismatch",
                employeeToSalary.get(thomasSmith), is(48_000));
        assertThat("John Doe's value mismatch",
                employeeToSalary.get(johnDoe), is(55_000));
        assertThat("Alice Cooper's value mismatch",
                employeeToSalary.get(aliceCooper), is(10_000_000));
    }

    @Test
    public void itShouldReplaceValueForDuplicateKey() {
        employeeToSalary.insert(johnDoe, 55_000);
        employeeToSalary.insert(thomasSmith, 48_000);
        employeeToSalary.insert(aliceCooper, 10_000_000);

        employeeToSalary.insert(thomasSmith, 50_000);

        assertThat("size mismatch", employeeToSalary.size(), is(3));
        assertThat("value mismatch",
                employeeToSalary.get(thomasSmith), is(50_000));
    }

    @Test
    public void itShouldDecreaseSizeWhenElementsRemoved() {
        employeeToSalary.insert(johnDoe, 55_000);
        employeeToSalary.insert(thomasSmith, 48_000);
        employeeToSalary.insert(aliceCooper, 10_000_000);

        assertThat("size mismatch", employeeToSalary.size(), is(3));

        employeeToSalary.remove(johnDoe);
        assertThat("size mismatch", employeeToSalary.size(), is(2));

        employeeToSalary.remove(thomasSmith);
        assertThat("size mismatch", employeeToSalary.size(), is(1));

        employeeToSalary.remove(aliceCooper);
        assertThat("size mismatch", employeeToSalary.size(), is(0));
    }

    @Test
    public void itShouldAllowNullAsKey() {
        employeeToSalary.insert(null, 10);

        assertThat(employeeToSalary.get(null), is(10));
    }

    @Test
    public void itShouldIncreaseSizeForDifferentKeysWithIdenticalHashCode() {
        employeeToSalary.insert(emilyIdenticalHashCode, 55_000);
        assertThat("size mismatch", employeeToSalary.size(), is(1));

        employeeToSalary.insert(sabineIdenticalHashCode, 49_000);
        assertThat("size mismatch", employeeToSalary.size(), is(2));
    }

    @Test
    public void itShouldRemoveOnlySpecifiedKeyDisregardingToOthersWithIdenticalHashCode() {
        employeeToSalary.insert(emilyIdenticalHashCode, 55_000);
        employeeToSalary.insert(sabineIdenticalHashCode, 49_000);

        employeeToSalary.remove(emilyIdenticalHashCode);

        assertThat("Emily's contains mismatch",
                employeeToSalary.contains(emilyIdenticalHashCode), is(false));

        assertThat("Sabine's contains mismatch",
                employeeToSalary.contains(sabineIdenticalHashCode), is(true));
    }

}
