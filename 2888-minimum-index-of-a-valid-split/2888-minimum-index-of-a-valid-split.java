import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Find the dominant element
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        // Step 2: Count occurrences of the dominant element
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalCount++;
            }
        }
        
        // Step 3: Find the minimum valid split index
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int rightCount = totalCount - leftCount;
            
            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - i - 1)) {
                return i;
            }
        }
        
        return -1;
    }
}
