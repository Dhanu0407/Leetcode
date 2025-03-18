class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitwiseOR = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // If adding nums[right] makes the AND non-zero, shrink the window
            while ((bitwiseOR & nums[right]) != 0) {
                bitwiseOR ^= nums[left];  // Remove nums[left] from bitwiseOR
                left++;  // Move the left pointer
            }

            // Add the current number to the OR result
            bitwiseOR |= nums[right];

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
