class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns
        int[] rowCount = new int[m]; // Count of servers in each row
        int[] colCount = new int[n]; // Count of servers in each column
        
        // Step 1: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int count = 0; // To store the total number of communicating servers
        
        // Step 2: Check if a server can communicate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
