class Solution {
    private int n;
    private int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public int largestIsland(int[][] grid) {
        n = grid.length;
        int maxIsland = 0;
        boolean hasZero = false;
        int islandId = 2;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        
        // Step 1: Label islands and record their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }
        
        // Step 2: Try changing a single 0 to 1 and calculate the largest possible island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> seenIslands = new HashSet<>();
                    int newSize = 1; // The newly changed cell
                    
                    for (int[] dir : directions) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (isValid(ni, nj) && grid[ni][nj] > 1) {
                            int island = grid[ni][nj];
                            if (!seenIslands.contains(island)) {
                                newSize += islandSizes.get(island);
                                seenIslands.add(island);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }
        
        return hasZero ? maxIsland : n * n;
    }
    
    private int dfs(int[][] grid, int i, int j, int islandId) {
        if (!isValid(i, j) || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        int size = 1;
        for (int[] dir : directions) {
            size += dfs(grid, i + dir[0], j + dir[1], islandId);
        }
        return size;
    }
    
    private boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}