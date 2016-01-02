package meetup_17_dictionary.misc;

import junitparams.Parameters;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IdenticalHashCodeEmployeeTest extends EmployeeTest {

    @Test
    @Parameters(method = "namesAndIds")
    public void itShouldReturnIdenticalHashCode(String name, int id) {
        Employee employee = new IdenticalHashCodeEmployee(name, id);

        assertThat(employee.hashCode(), is(0));
    }

}
