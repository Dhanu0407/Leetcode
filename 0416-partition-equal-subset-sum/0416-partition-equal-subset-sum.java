class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, cannot partition into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // zero sum is always possible with empty subset

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
