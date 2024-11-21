class Solution {

    // Corrected markGuarded method signature
    void markGuarded(int row, int col, int[][] grid) {
        // Mark cells upwards
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1;
        }

        // Mark cells downwards
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1;
        }

        // Mark cells to the left
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1;
        }

        // Mark cells to the right
        for (int j = col + 1; j < grid[row].length; j++) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Initialize the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }

        // Mark guards
        for (int[] vec : guards) {
            int i = vec[0];
            int j = vec[1];
            grid[i][j] = 2;
        }

        // Mark walls
        for (int[] vec : walls) {
            int i = vec[0];
            int j = vec[1];
            grid[i][j] = 3;
        }

        // Mark cells guarded by guards
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            markGuarded(i, j, grid);
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}