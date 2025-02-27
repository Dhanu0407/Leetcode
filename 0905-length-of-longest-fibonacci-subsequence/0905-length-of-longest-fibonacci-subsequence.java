import java.util.HashMap;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n]; // DP table
        int maxLen = 0;

        // Map each number to its index for quick lookups
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate over pairs (j, k)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prev = arr[j] - arr[i]; // Expected previous element
                if (prev < arr[i] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    dp[i][j] = 2; // Start a new sequence
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen > 2 ? maxLen : 0; // Fibonacci sequence must have at least 3 elements
    }
}
