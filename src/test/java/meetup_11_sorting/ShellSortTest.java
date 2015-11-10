package meetup_11_sorting;

public class ShellSortTest<E extends Comparable<E>>
        extends AbstractSortTest<E> {

    @Override
    protected ShellSort<E> createSort() {
        return new ShellSort<>();
    }

}
