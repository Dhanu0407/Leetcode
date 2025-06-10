import java.util.*;

class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        
        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> oddFreqs = new ArrayList<>();
        List<Integer> evenFreqs = new ArrayList<>();

        // Separate odd and even frequencies
        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 1) {
                    oddFreqs.add(f);
                } else {
                    evenFreqs.add(f);
                }
            }
        }

        int maxDiff = Integer.MIN_VALUE;

        // Compute max difference
        for (int odd : oddFreqs) {
            for (int even : evenFreqs) {
                maxDiff = Math.max(maxDiff, odd - even);
            }
        }

        return maxDiff;
    }
}
