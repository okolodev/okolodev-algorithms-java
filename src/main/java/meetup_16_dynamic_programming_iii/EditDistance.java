package meetup_16_dynamic_programming_iii;

/**
 * <p>
 * 72. Edit Distance
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/edit-distance/">72. Edit Distance</a>
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] distances = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            distances[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            distances[0][i] = i;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    distances[i + 1][j + 1] = distances[i][j];
                } else {
                    int insertDistance = distances[i + 1][j];
                    int deleteDistance = distances[i][j + 1];
                    int replaceDistance = distances[i][j];

                    distances[i + 1][j + 1] = Math.min(insertDistance,
                            Math.min(deleteDistance, replaceDistance)) + 1;
                }
            }
        }

//        debug(distances, word1, word2);

        return distances[word1.length()][word2.length()];
    }

//    private void debug(int[][] distances, String word1, String word2) {
//        String topRow = Arrays.toString(word2.toCharArray());
//        System.out.println("     " + topRow.substring(1, topRow.length() - 1));
//        for (int i = 0; i < distances.length; i++) {
//            if (i > 0) {
//                System.out.print(word1.charAt(i - 1));
//            } else {
//                System.out.print(" ");
//            }
//            System.out.println(Arrays.toString(distances[i]));
//        }
//    }

}
