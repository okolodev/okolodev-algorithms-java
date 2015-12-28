package meetup_17_dictionary;

import meetup_17_dictionary.misc.Employee;

public class HashDictionaryTest extends DictionaryAbstractTest {

    @Override
    protected Dictionary<Employee, Integer> createDictionary() {
        return new HashDictionary<>((double) 2 / 3);
    }

}
