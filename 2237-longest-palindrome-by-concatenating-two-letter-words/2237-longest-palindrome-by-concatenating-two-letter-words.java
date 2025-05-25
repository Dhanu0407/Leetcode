import java.util.HashMap;

class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean hasCenter = false;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(rev, 0) > 0) {
                // We can form a pair
                length += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                // Store this word for later pairing
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check for a central symmetric word
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1) && map.get(word) > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }
}
