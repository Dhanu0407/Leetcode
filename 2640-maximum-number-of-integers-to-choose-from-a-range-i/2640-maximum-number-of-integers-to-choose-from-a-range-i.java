

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a HashSet for quick lookup of banned numbers
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        
        int currentSum = 0;
        int count = 0;
        
        // Iterate through integers in the range [1, n]
        for (int i = 1; i <= n; i++) {
            // Check if the number is banned or if adding it exceeds maxSum
            if (!bannedSet.contains(i) && currentSum + i <= maxSum) {
                currentSum += i; // Add the number to the current sum
                count++;         // Increment the count of chosen numbers
            }
        }
        
        return count; // Return the total count of numbers chosen
    }
}
