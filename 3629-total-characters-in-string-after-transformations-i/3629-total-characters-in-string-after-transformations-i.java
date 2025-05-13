class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] counts = new long[26];  // frequency of 'a' to 'z'

        // Step 1: Initialize character counts from the input string
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // Step 2: Perform t transformations
        for (int i = 0; i < t; i++) {
            long[] newCounts = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // 'z'
                    newCounts[0] = (newCounts[0] + counts[25]) % MOD; // 'a'
                    newCounts[1] = (newCounts[1] + counts[25]) % MOD; // 'b'
                } else {
                    newCounts[j + 1] = (newCounts[j + 1] + counts[j]) % MOD;
                }
            }
            counts = newCounts; // Update for next transformation
        }

        // Step 3: Sum the final counts to get the total length
        long result = 0;
        for (long count : counts) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }
}
