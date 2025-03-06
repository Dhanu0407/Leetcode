class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        
        int[] freq = new int[size + 1]; // Frequency array to count occurrences
        int repeated = -1, missing = -1;
        
        // Count occurrences of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }
        
        // Find the missing and repeated numbers
        for (int i = 1; i <= size; i++) {
            if (freq[i] == 2) {
                repeated = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }
        
        return new int[]{repeated, missing};
    }
}
