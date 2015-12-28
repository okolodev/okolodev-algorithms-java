package meetup_17_dictionary;

public interface Dictionary<K, V> {

    void insert(K key, V value);

    boolean contains(K key);

    V get(K key);

    void remove(K key);

    int size();

    boolean isEmpty();

}
