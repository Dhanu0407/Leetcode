import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        
        // Step 2: Sliding window to calculate maximum beauty
        int maxBeauty = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Step 3: Check if nums[right] is out of range of nums[left]
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            // Step 4: Update maximum beauty
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
