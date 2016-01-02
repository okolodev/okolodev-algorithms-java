package meetup_17_dictionary.misc;

public class IdenticalHashCodeEmployee extends Employee {

    public IdenticalHashCodeEmployee(String name, int id) {
        super(name, id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
