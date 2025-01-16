class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        
        // Compute XOR of all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }
        
        // Compute XOR of all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }
        
        // Determine the final XOR result
        int result = 0;
        if (nums2.length % 2 == 1) {
            result ^= xor1;
        }
        if (nums1.length % 2 == 1) {
            result ^= xor2;
        }
        
        return result;
    }
}
