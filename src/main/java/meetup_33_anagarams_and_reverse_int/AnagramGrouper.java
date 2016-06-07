package meetup_33_anagarams_and_reverse_int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 *
 * @see <a href="https://leetcode.com/problems/anagrams/">49. Group Anagrams </a>
 */
public class AnagramGrouper {

    public List<List<String>> groupAnagrams(String... words) {
        Arrays.sort(words);

        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String word : words) {
            String wordWithSortedLetters = sortWordLetters(word);

            if (!map.containsKey(wordWithSortedLetters)) {
                map.put(wordWithSortedLetters, new ArrayList<>());
            }

            map.get(wordWithSortedLetters).add(word);
        }

        return new ArrayList<>(map.values());
    }

    private String sortWordLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);

        return new String(letters);
    }

}
