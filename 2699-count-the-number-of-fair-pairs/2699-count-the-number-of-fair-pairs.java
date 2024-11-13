
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);  // Step 1: Sort the array
        long count = 0;
        int n = nums.length;
        
        // Step 2: Use two pointers or binary search approach for each element
        for (int i = 0; i < n - 1; i++) {
            int left = binarySearchLeft(nums, i + 1, n - 1, lower - nums[i]);
            int right = binarySearchRight(nums, i + 1, n - 1, upper - nums[i]);
            
            if (left != -1 && right != -1 && left <= right) {
                count += (right - left + 1);  // Add number of fair pairs for this index i
            }
        }
        
        return count;
    }

    // Binary search for the first index with nums[index] >= target
    private int binarySearchLeft(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left <= end ? left : -1;
    }

    // Binary search for the last index with nums[index] <= target
    private int binarySearchRight(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= start ? right : -1;
    }
}
