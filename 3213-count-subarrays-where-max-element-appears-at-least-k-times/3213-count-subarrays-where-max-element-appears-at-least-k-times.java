public class Solution {
    /**
     * Returns the number of subarrays where the global maximum element appears at least k times.
     *
     * Approach:
     * 1. Find the maximum value `max` in the array.
     * 2. Build a prefix-sum array `count` where count[i] = number of occurrences of `max` in nums[0..i-1].
     * 3. Use a two-pointer (sliding window on prefixes) technique:
     *    - Maintain a pointer `j` into the prefix array such that for each end index `i`,
     *      all prefixes `count[0..j-1]` satisfy count[i] - count[prefix] >= k.
     *    - We increment `j` while the difference remains >= k.
     *    - The number of valid subarrays ending at `i-1` is exactly `j`.
     * 4. Sum these counts over all `i` to get the total.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        // 1. Find global maximum
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        // 2. Build prefix counts of occurrences of max
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i - 1] + (nums[i - 1] == max ? 1 : 0);
        }
        
        // 3. Two-pointer on prefix sums
        long result = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            while (j < i && count[i] - count[j] >= k) {
                j++;
            }
            // All prefixes [0..j-1] give subarrays ending at i-1 with >=k occurrences of max
            result += j;
        }
        return result;
    }
}
