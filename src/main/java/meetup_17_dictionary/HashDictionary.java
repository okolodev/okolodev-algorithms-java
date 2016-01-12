package meetup_17_dictionary;

import java.math.BigInteger;
import java.util.Objects;

public class HashDictionary<K, V> implements Dictionary<K, V> {
    private final double loadFactor;

    private int size;
    private Entry<K, V>[] buckets;

    public HashDictionary() {
        this(1);
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashDictionary(double loadFactor) {
        this.loadFactor = loadFactor;
        buckets = (Entry<K, V>[]) new Entry[0];
    }

    @Override
    public void insert(K key, V value) {
        Entry<K, V> entry = findEntry(key);

        if (entry != null) {
            entry.value = value;
            return;
        }

        increaseCapacityOnDemand();
        int hashIndex = hashIndex(key);
        buckets[hashIndex] = new Entry<>(key, value, buckets[hashIndex]);
        size++;
    }

    private void increaseCapacityOnDemand() {
        double load = capacity() * loadFactor;

        if ((size + 1) >= load) {
            int newCapacity = nextPrime(capacity() * 2);
            buckets = rehash(newCapacity);
        }
    }

    private Entry<K, V>[] rehash(int newCapacity) {
        Entry<K, V>[] newBuckets = (Entry<K, V>[]) new Entry[newCapacity];

        for (Entry<K, V> entry : buckets) {
            while (entry != null) {
                int hashIndex = hashIndex(entry.key, newCapacity);
                newBuckets[hashIndex] = new Entry<>(entry.key, entry.value,
                        newBuckets[hashIndex]);
                entry = entry.next;
            }
        }

        return newBuckets;
    }

    private int nextPrime(int n) {
        return BigInteger.valueOf(n).nextProbablePrime().intValue();
    }

    @Override
    public boolean contains(K key) {
        return findEntry(key) != null;
    }

    private int hashIndex(K key) {
        return hashIndex(key, buckets.length);
    }

    private int hashIndex(K key, int capacity) {
        return Math.abs(Objects.hashCode(key) % capacity);
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = findEntry(key);

        if (entry != null) {
            return entry.value;
        }

        return null;
    }

    private Entry<K, V> findEntry(K key) {
        if (isEmpty()) {
            return null;
        }

        int hashIndex = hashIndex(key);
        Entry<K, V> entry = buckets[hashIndex];

        while (entry != null) {
            if (Objects.equals(key, entry.key)) {
                return entry;
            }
            entry = entry.next;
        }

        return null;
    }

    @Override
    public void remove(K key) {
        if (isEmpty()) {
            return;
        }

        int hashIndex = hashIndex(key);
        Entry<K, V> entry = buckets[hashIndex];
        Entry<K, V> previousEntry = null;

        while (entry != null) {
            if (key.equals(entry.key)) {
                if (previousEntry == null) {
                    buckets[hashIndex] = entry.next;
                } else {
                    previousEntry.next = entry.next;
                }

                size--;
                decreaseCapacityOnDemand();
                return;
            }

            previousEntry = entry;
            entry = entry.next;
        }
    }

    private void decreaseCapacityOnDemand() {
        double load = capacity() * loadFactor;

        if (load / 2 >= size) {
            int newCapacity = nextPrime(capacity() / 2);
            buckets = rehash(newCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return buckets.length;
    }

}
