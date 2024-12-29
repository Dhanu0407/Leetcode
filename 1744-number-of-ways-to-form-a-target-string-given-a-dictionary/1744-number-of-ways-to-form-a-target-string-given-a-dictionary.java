class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int m = target.length();
        int n = words[0].length();
        
        // Preprocess character frequencies
        int[][] freq = new int[26][n];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                freq[word.charAt(j) - 'a'][j]++;
            }
        }
        
        // DP array
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: There's one way to form an empty target
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Option 1: Skip the current column
                dp[i][j] = dp[i][j - 1];
                
                // Option 2: Use the current column if it matches target[i-1]
                char targetChar = target.charAt(i - 1);
                if (freq[targetChar - 'a'][j - 1] > 0) {
                    dp[i][j] += (int)((long) dp[i - 1][j - 1] * freq[targetChar - 'a'][j - 1] % MOD);
                    dp[i][j] %= MOD;
                }
            }
        }
        
        return dp[m][n];
    }
}
