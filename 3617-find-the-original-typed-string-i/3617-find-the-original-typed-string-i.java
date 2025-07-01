import java.util.*;

class Solution {
    public int possibleStringCount(String word) {
        Set<String> possibleStrings = new HashSet<>();
        possibleStrings.add(word); // Add the original word

        int n = word.length();
        for (int i = 0; i < n;) {
            int j = i;
            // Find group of repeated characters
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }

            int count = j - i;
            if (count >= 2) {
                for (int len = 1; len < count; len++) {
                    // Construct a new word by reducing this group to `len` characters
                    String newWord = word.substring(0, i) +
                                     repeatChar(word.charAt(i), len) +
                                     word.substring(j);
                    possibleStrings.add(newWord);
                }
            }

            i = j;
        }

        return possibleStrings.size();
    }

    private String repeatChar(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) sb.append(c);
        return sb.toString();
    }
}
