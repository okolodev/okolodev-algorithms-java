package meetup_31_bloom_filter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class BloomFilter {
    private final int size;
    private final int hashFunctionNumber;
    private final BitSet filter;

    private MessageDigest md5Function;
    private MessageDigest sha1Function;

    public BloomFilter(int size, int hashFunctionNumber) {
        this.size = size;
        this.hashFunctionNumber = hashFunctionNumber;
        filter = new BitSet(size);

        try {
            md5Function = MessageDigest.getInstance("MD5");
            sha1Function = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return size;
    }

    public int getHashFunctionNumber() {
        return hashFunctionNumber;
    }

    public void put(String key) {
        int md5Hash = computeHash(md5Function, key);
        int sha1Hash = computeHash(sha1Function, key);

        for (int i = 1; i <= hashFunctionNumber; i++) {
            int doubleHash = md5Hash + i * sha1Hash;
            int bitIndex = Math.abs(doubleHash) % size;
            filter.set(bitIndex, true);
        }
    }

    public boolean contains(String key) {
        int md5Hash = computeHash(md5Function, key);
        int sha1Hash = computeHash(sha1Function, key);

        for (int i = 1; i <= hashFunctionNumber; i++) {
            int doubleHash = md5Hash + i * sha1Hash;
            int bitIndex = Math.abs(doubleHash) % size;

            if (!filter.get(bitIndex)) {
                return false;
            }
        }

        return true;
    }

    private int computeHash(MessageDigest hashFunction, String key) {
        hashFunction.reset();
        hashFunction.update(key.getBytes());
        byte[] digest = hashFunction.digest();

        return new BigInteger(1, digest).intValue();
    }

}
