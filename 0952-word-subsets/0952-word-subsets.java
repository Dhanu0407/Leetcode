import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Compute the maximum frequency of each character across all words in words2
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = getCharFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = getCharFrequency(word);
            if (isUniversal(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper method to compute character frequency for a given word
    private int[] getCharFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper method to check if a word's frequency satisfies the maxFreq requirements
    private boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
