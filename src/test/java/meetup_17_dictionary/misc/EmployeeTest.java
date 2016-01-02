package meetup_17_dictionary.misc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EmployeeTest {

    @Test
    @Parameters(method = "namesAndIds")
    public void itShouldHaveName(String name, int id) {
        Employee employee = new Employee(name, id);

        assertThat(employee.getName(), is(name));
    }

    @Test
    @Parameters(method = "namesAndIds")
    public void itShouldHaveId(String name, int id) {
        Employee employee = new Employee(name, id);

        assertThat(employee.getId(), is(id));
    }

    @Test
    @Parameters(method = "namesAndIds")
    public void twoEmployeesShouldBeEqualIfTheyHaveSameNameAndId(String name,
                                                                 int id) {
        Employee firstEmployee = new Employee(name, id);
        Employee secondEmployee = new Employee(name, id);

        assertThat(firstEmployee, is(secondEmployee));
    }

    @Test
    @Parameters(method = "namesAndIds")
    public void twoEqualEmployeesShouldHaveEqualHashCode(String name,
                                                         int id) {
        Employee firstEmployee = new Employee(name, id);
        Employee secondEmployee = new Employee(name, id);

        assertThat(firstEmployee.hashCode(), is(secondEmployee.hashCode()));
    }

    @Test
    @Parameters(method = "namesAndIds")
    public void itShouldNotBeEqualToNull(String name, int id) {
        Employee employee = new Employee(name, id);

        assertThat(employee, is(not(equalTo(null))));
    }

    protected Object[][] namesAndIds() {
        return new Object[][]{
                {"John Doe", 1},
                {"Thomas Smith", 2},
                {"Alice Cooper", 3}
        };
    }

}
