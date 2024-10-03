
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        // Step 1: Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Find the remainder when total sum is divided by p
        long remainder = totalSum % p;
        if (remainder == 0) {
            return 0; // If sum is already divisible by p, no need to remove anything
        }

        // Step 3: Initialize hash map to store prefix sums modulo p
        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, -1);  // Base case to handle the full prefix sum
        long currentPrefix = 0;
        int minLength = n;

        // Step 4: Traverse the array to find the smallest subarray to remove
        for (int i = 0; i < n; i++) {
            currentPrefix = (currentPrefix + nums[i]) % p;
            long target = (currentPrefix - remainder + p) % p; // Find the target prefix sum

            if (prefixMap.containsKey(target)) {
                minLength = Math.min(minLength, i - prefixMap.get(target));
            }

            // Store the current prefix sum modulo p in the map
            prefixMap.put(currentPrefix, i);
        }

        // Step 5: Return the minimum length of the subarray to remove or -1 if not possible
        return (minLength == n) ? -1 : minLength;
    }
}
