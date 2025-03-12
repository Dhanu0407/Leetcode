class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstNonNegativeIndex(nums); // Count of negative numbers
        int posCount = nums.length - findFirstPositiveIndex(nums); // Count of positive numbers
        return Math.max(negCount, posCount);
    }

    // Binary search to find the first non-negative number (0 or positive)
    private int findFirstNonNegativeIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) { 
                left = mid + 1; // Move right to find the first non-negative
            } else {
                right = mid - 1;
            }
        }
        return left; // The first index where nums[index] >= 0
    }

    // Binary search to find the first positive number
    private int findFirstPositiveIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) { 
                left = mid + 1; // Move right to find the first positive
            } else {
                right = mid - 1;
            }
        }
        return left; // The first index where nums[index] > 0
    }
}
