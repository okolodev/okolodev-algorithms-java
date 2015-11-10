package meetup_11_sorting;

public interface Sort<E extends Comparable<E>> {

    E[] sort(E[] elements);

}
