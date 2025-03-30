import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        // Step 1: Store the last index of each character in the string
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Traverse the string to determine partitions
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // When we reach the end of a partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1; // Move to the next partition
            }
        }

        return result;
    }
}
