package meetup_17_dictionary.misc;

import java.util.Objects;

public class Employee {
    private final String name;
    private final int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) o;

        return Objects.equals(name, other.name)
                && id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + id;

        return hash;
    }

}
