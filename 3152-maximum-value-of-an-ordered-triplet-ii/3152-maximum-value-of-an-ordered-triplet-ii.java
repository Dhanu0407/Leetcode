class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        long maxValue = 0;

        // Prefix maximum array
        int[] maxPrefix = new int[n];
        maxPrefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }

        // Suffix maximum array
        int[] maxSuffix = new int[n];
        maxSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], nums[i]);
        }

        // Iterate through possible j values (1 to n-2)
        for (int j = 1; j < n - 1; j++) {
            long max_i = maxPrefix[j - 1];  // Max nums[i] for i < j
            long max_k = maxSuffix[j + 1];  // Max nums[k] for k > j

            long value = (max_i - nums[j]) * max_k;
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }
}
